/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.mybatis;

import com.yize.cheesecake.common.exception.ExceptionCatch;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class MyBatisUtils {

    public static SqlSession getSqlSession() throws IOException, SQLException {
        SqlSession sqlSession;
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        if (sqlSession == null) {
            /*无法建立 mysql 连接池*/
            throw new SQLException(ExceptionCatch.MYSQL_SVR_ERROR);
        }
        return sqlSession;
    }
}
