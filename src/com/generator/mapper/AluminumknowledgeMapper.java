package com.generator.mapper;

import com.generator.entity.Aluminumknowledge;
import java.util.List;

public interface AluminumknowledgeMapper {
    int deleteByPrimaryKey(String processno);

    int insert(Aluminumknowledge record);

    Aluminumknowledge selectByPrimaryKey(String processno);

    List<Aluminumknowledge> selectAll();

    int updateByPrimaryKey(Aluminumknowledge record);
}