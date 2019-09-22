package com.generator.mapper;

import com.generator.entity.Palmer;
import java.util.List;

public interface PalmerMapper {
    int deleteByPrimaryKey(String partno);

    int insert(Palmer record);

    Palmer selectByPrimaryKey(String partno);

    List<Palmer> selectAll();

    int updateByPrimaryKey(Palmer record);
}