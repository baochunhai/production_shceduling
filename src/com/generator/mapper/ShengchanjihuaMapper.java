package com.generator.mapper;

import com.generator.entity.Shengchanjihua;
import java.util.List;

public interface ShengchanjihuaMapper {
    int insert(Shengchanjihua record);

    List<Shengchanjihua> selectAll();
}