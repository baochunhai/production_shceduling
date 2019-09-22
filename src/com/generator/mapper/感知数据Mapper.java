package com.generator.mapper;

import com.generator.entity.感知数据;
import java.util.List;

public interface 感知数据Mapper {
    int deleteByPrimaryKey(String 任务号);

    int insert(感知数据 record);

    感知数据 selectByPrimaryKey(String 任务号);

    List<感知数据> selectAll();

    int updateByPrimaryKey(感知数据 record);
}