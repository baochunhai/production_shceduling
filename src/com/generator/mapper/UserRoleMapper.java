package com.generator.mapper;

import com.generator.entity.UserRole;
import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();
}