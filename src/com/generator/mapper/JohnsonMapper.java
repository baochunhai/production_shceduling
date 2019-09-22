package com.generator.mapper;

import com.generator.entity.Johnson;
import java.util.List;

public interface JohnsonMapper {
    int deleteByPrimaryKey(String partno);

    int insert(Johnson record);

    Johnson selectByPrimaryKey(String partno);

    List<Johnson> selectAll();

    int updateByPrimaryKey(Johnson record);
}