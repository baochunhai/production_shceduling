package com.generator.mapper;

import com.generator.entity.Proctime1;
import java.util.List;

public interface Proctime1Mapper {
    int deleteByPrimaryKey(String partno);

    int insert(Proctime1 record);

    Proctime1 selectByPrimaryKey(String partno);

    List<Proctime1> selectAll();

    int updateByPrimaryKey(Proctime1 record);
}