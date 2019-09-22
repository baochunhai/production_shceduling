package com.generator.mapper;

import com.generator.entity.Resourceanalysis;
import java.util.List;

public interface ResourceanalysisMapper {
    int insert(Resourceanalysis record);

    List<Resourceanalysis> selectAll();
}