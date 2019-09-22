package com.generator.mapper;

import com.generator.entity.Cdsjohnson;
import java.util.List;

public interface CdsjohnsonMapper {
    int deleteByPrimaryKey(String partno);

    int insert(Cdsjohnson record);

    Cdsjohnson selectByPrimaryKey(String partno);

    List<Cdsjohnson> selectAll();

    int updateByPrimaryKey(Cdsjohnson record);
}