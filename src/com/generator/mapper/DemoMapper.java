package com.generator.mapper;

import com.generator.entity.Demo;
import java.util.List;

public interface DemoMapper {
    int insert(Demo record);

    List<Demo> selectAll();
}