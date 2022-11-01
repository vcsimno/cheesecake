/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.mapper;

import com.yize.cheesecake.authorize.pojo.Online;
import com.yize.cheesecake.authorize.pojo.OnlineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineMapper {
    long countByExample(OnlineExample example);

    int deleteByExample(OnlineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Online record);

    int insertSelective(Online record);

    List<Online> selectByExample(OnlineExample example);

    Online selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Online record, @Param("example") OnlineExample example);

    int updateByExample(@Param("record") Online record, @Param("example") OnlineExample example);

    int updateByPrimaryKeySelective(Online record);

    int updateByPrimaryKey(Online record);
}