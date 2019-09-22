package com.generator.mapper;

import com.generator.entity.Gaselectedmpsno;
import java.util.List;

public interface GaselectedmpsnoMapper {
    int deleteByPrimaryKey(String mpsno);

    int insert(Gaselectedmpsno record);

    List<Gaselectedmpsno> selectAll();
}