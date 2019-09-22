package com.generator.mapper;

import com.generator.entity.ResourceNull;
import java.util.List;

public interface ResourceNullMapper {
    int insert(ResourceNull record);

    List<ResourceNull> selectAll();
}