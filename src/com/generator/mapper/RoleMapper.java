package com.generator.mapper;

import com.generator.entity.Role;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(Role record);

    Role selectByPrimaryKey(Long uuid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}