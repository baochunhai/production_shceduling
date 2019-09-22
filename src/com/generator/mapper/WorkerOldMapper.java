package com.generator.mapper;

import com.generator.entity.WorkerOld;
import java.util.List;

public interface WorkerOldMapper {
    int insert(WorkerOld record);

    List<WorkerOld> selectAll();
}