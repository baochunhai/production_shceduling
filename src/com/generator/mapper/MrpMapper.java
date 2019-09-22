package com.generator.mapper;

import com.generator.entity.Mrp;
import java.util.List;

public interface MrpMapper {
    int deleteByPrimaryKey(String 任务号);

    int insert(Mrp record);

    Mrp selectByPrimaryKey(String 任务号);

    List<Mrp> selectAll();

    int updateByPrimaryKey(Mrp record);
}