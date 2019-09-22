package com.generator.mapper;

import com.generator.entity.Resourceresult;
import java.util.List;

public interface ResourceresultMapper {
    int insert(Resourceresult record);

    List<Resourceresult> selectAll();
}