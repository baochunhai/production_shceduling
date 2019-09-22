package com.generator.mapper;

import com.generator.entity.UserU;
import java.util.List;

public interface UserUMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserU record);

    UserU selectByPrimaryKey(Long userId);

    List<UserU> selectAll();

    int updateByPrimaryKey(UserU record);
}