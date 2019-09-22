package com.generator.mapper;

import com.generator.entity.Proctime2;
import java.util.List;

public interface Proctime2Mapper {
    int insert(Proctime2 record);

    List<Proctime2> selectAll();
}