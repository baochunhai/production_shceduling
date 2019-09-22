package com.generator.mapper;

import com.generator.entity.RoleMenu;
import java.util.List;

public interface RoleMenuMapper {
    int insert(RoleMenu record);

    List<RoleMenu> selectAll();
}