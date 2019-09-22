package com.generator.mapper;

import com.generator.entity.Timeknowledge;
import java.util.List;

public interface TimeknowledgeMapper {
    int insert(Timeknowledge record);

    List<Timeknowledge> selectAll();
}