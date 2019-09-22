package com.generator.mapper;

import com.generator.entity.Carbonknowledge;
import java.util.List;

public interface CarbonknowledgeMapper {
    int deleteByPrimaryKey(String processno);

    int insert(Carbonknowledge record);

    Carbonknowledge selectByPrimaryKey(String processno);

    List<Carbonknowledge> selectAll();

    int updateByPrimaryKey(Carbonknowledge record);
}