package com.generator.mapper;

import com.generator.entity.Analysisequipment;
import java.util.List;

public interface AnalysisequipmentMapper {
    int insert(Analysisequipment record);

    List<Analysisequipment> selectAll();
}