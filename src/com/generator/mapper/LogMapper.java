package com.generator.mapper;

import com.generator.entity.Log;
import java.math.BigDecimal;
import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Log record);

    Log selectByPrimaryKey(BigDecimal id);

    List<Log> selectAll();

    int updateByPrimaryKey(Log record);
}