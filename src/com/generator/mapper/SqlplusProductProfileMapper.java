package com.generator.mapper;

import com.generator.entity.SqlplusProductProfile;
import java.util.List;

public interface SqlplusProductProfileMapper {
    int insert(SqlplusProductProfile record);

    List<SqlplusProductProfile> selectAll();
}