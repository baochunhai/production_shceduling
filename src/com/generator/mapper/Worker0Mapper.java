package com.generator.mapper;

import com.generator.entity.Worker0;
import java.util.List;

public interface Worker0Mapper {
    int deleteByPrimaryKey(String id);

    int insert(Worker0 record);

    Worker0 selectByPrimaryKey(String id);

    List<Worker0> selectAll();

    int updateByPrimaryKey(Worker0 record);
}