package com.generator.mapper;

import com.generator.entity.AluminumProcessknowledge;
import java.util.List;

public interface AluminumProcessknowledgeMapper {
    int insert(AluminumProcessknowledge record);

    List<AluminumProcessknowledge> selectAll();
}