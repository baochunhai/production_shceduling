package com.generator.mapper;

import com.generator.entity.Gaparameters;
import java.util.List;

public interface GaparametersMapper {
    int deleteByPrimaryKey(String paraname);

    int insert(Gaparameters record);

    Gaparameters selectByPrimaryKey(String paraname);

    List<Gaparameters> selectAll();

    int updateByPrimaryKey(Gaparameters record);
}