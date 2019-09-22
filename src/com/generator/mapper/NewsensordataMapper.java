package com.generator.mapper;

import com.generator.entity.Newsensordata;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsensordataMapper {
    int deleteByPrimaryKey(@Param("recorddate") String recorddate, @Param("mpsno") String mpsno, @Param("processno") String processno);

    int insert(Newsensordata record);

    Newsensordata selectByPrimaryKey(@Param("recorddate") String recorddate, @Param("mpsno") String mpsno, @Param("processno") String processno);

    List<Newsensordata> selectAll();

    int updateByPrimaryKey(Newsensordata record);
}