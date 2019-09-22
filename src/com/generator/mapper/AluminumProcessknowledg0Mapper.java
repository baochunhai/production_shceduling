package com.generator.mapper;

import com.generator.entity.AluminumProcessknowledg0;
import java.util.List;

public interface AluminumProcessknowledg0Mapper {
    int deleteByPrimaryKey(String 工艺顺序);

    int insert(AluminumProcessknowledg0 record);

    AluminumProcessknowledg0 selectByPrimaryKey(String 工艺顺序);

    List<AluminumProcessknowledg0> selectAll();

    int updateByPrimaryKey(AluminumProcessknowledg0 record);
}