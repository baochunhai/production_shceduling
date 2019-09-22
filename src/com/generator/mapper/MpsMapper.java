package com.generator.mapper;

import com.generator.entity.Mps;
import java.util.List;

public interface MpsMapper {
    int deleteByPrimaryKey(String mpsno);

    int insert(Mps record);

    Mps selectByPrimaryKey(String mpsno);

    List<Mps> selectAll();

    int updateByPrimaryKey(Mps record);
}