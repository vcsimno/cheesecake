
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.aspect;

import com.yize.cheesecake.authorize.utils.redis.RedisUtils;
import com.yize.cheesecake.authorize.utils.redis.RedisUtilsSu;
import com.yize.cheesecake.common.annotation.RequiresRoles;
import com.yize.cheesecake.common.aspect.PermissionTest;
import com.yize.cheesecake.common.authorize.Access_Token;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import com.yize.cheesecake.common.exception.YiAuthRuntimeExeception;
import com.yize.cheesecake.common.header.GetHeader;
import com.yize.cheesecake.common.redis.RedisKeys;
import com.yize.cheesecake.common.utils.packer.PackerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/*
     请求需要某角色的注解
     【boss,staff,user,su,suAdmin】 boss=店长; staff=店员;user=用户;su=平台老总;suAdmin平台管理员
 */
@Component
@Aspect
public class RequiresRolesAspect {

    @Pointcut("@annotation(com.yize.cheesecake.common.annotation.RequiresRoles)")
    private void Requires() {
    }

    /**
     * 环绕通知
     */
    @Around("Requires()")
    public Object advice(ProceedingJoinPoint joinPoint) throws YiAuthRuntimeExeception {

        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        Method method = null;
        try {
            /*获得运行类中的方法*/
            method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        /*读取注解中提交的数据*/
        RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
        String[] requireValue = requiresRoles.value(); // 读取注解中，提交过来的用户权限
        String requireMethod = requiresRoles.method(); // 读取注解中，本次校验的类型 {permission=权限; characters=角色}

        Object[] args = joinPoint.getArgs();
        String res = "";

        /*取得HTTP REQUEST数据*/
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes;

        try {
            /*授权标记*/
            boolean isAcception;
            /*取得access_token*/
            Access_Token access_token = new Access_Token(GetHeader.getUserToken());

            /*判定access_token标记的权限*/
            if (requireMethod.equals("characters")) {
                isAcception = PermissionTest.test(requireValue, access_token.getCharacters());
            } else {
                isAcception = PermissionTest.test(requireValue, access_token.getPermission());
            }
            if (isAcception) {
                /*如果token里面有写着包含了权限，那么连接redis进行二次确认*/
                RedisUtils redis = RedisUtils.Instance();
                redis.select(RedisUtilsSu.USERDB);
                String key = RedisKeys.USER_ACCESS_TOKEN.getValue() + access_token.getToken();
                String value = redis.getString(key);
                if (value.isEmpty()) {
                    /*用户未被授权使用该接口*/
                    return PackerFactory.SendUnAuthorizedCharacters();
                }
                Access_Token iToken = new Access_Token(value);
                /*进行二次确认*/
                if (requireMethod.equals("characters")) {
                    isAcception = PermissionTest.test(requireValue, iToken.getCharacters());
                } else {
                    isAcception = PermissionTest.test(requireValue, iToken.getPermission());
                }
                if (!isAcception) {
                    /*未发现有合法权限*/
                    if (requireMethod.equals("characters")) {
                        return PackerFactory.SendUnAuthorizedCharacters();
                    } else {
                        return PackerFactory.SendUnAuthorizedPermission();
                    }
                }
            }
        } catch (Exception e) {
            /*token不正确 无效的token*/
            throw new YiAuthRuntimeExeception(ExceptionCatch.INVALID_ACCESS_TOKEN);
        }
        try {
            //进行方法过滤
            //执行到这里走原来的方法
            res = joinPoint.proceed().toString();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return res;
    }

}
