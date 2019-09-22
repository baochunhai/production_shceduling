package com.generator.mapper;

import com.generator.entity.Worker;
import java.util.List;

public interface WorkerMapper {
    int deleteByPrimaryKey(String workerno);

    int insert(Worker record);

    Worker selectByPrimaryKey(String workerno);

    List<Worker> selectAll();

    int updateByPrimaryKey(Worker record);
}