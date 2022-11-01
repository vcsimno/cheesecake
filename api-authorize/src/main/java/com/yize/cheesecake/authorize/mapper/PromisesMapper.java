/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.mapper;

import com.yize.cheesecake.authorize.pojo.Promises;
import com.yize.cheesecake.authorize.pojo.PromisesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PromisesMapper {
    long countByExample(PromisesExample example);

    int deleteByExample(PromisesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Promises record);

    int insertSelective(Promises record);

    List<Promises> selectByExample(PromisesExample example);

    Promises selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Promises record, @Param("example") PromisesExample example);

    int updateByExample(@Param("record") Promises record, @Param("example") PromisesExample example);

    int updateByPrimaryKeySelective(Promises record);

    int updateByPrimaryKey(Promises record);
}