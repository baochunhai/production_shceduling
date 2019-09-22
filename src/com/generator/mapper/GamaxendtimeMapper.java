package com.generator.mapper;

import com.generator.entity.Gamaxendtime;
import java.util.List;

public interface GamaxendtimeMapper {
    int deleteByPrimaryKey(String maxendtime);

    int insert(Gamaxendtime record);

    List<Gamaxendtime> selectAll();
}