package com.generator.mapper;

import com.generator.entity.Sensordata;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensordataMapper {
    int deleteByPrimaryKey(@Param("partno") String partno, @Param("processno") String processno);

    int insert(Sensordata record);

    Sensordata selectByPrimaryKey(@Param("partno") String partno, @Param("processno") String processno);

    List<Sensordata> selectAll();

    int updateByPrimaryKey(Sensordata record);
}