package com.generator.mapper;

import com.generator.entity.Menu;
import java.util.List;

public interface MenuMapper {
    int insert(Menu record);

    List<Menu> selectAll();
}