package com.generator.mapper;

import com.generator.entity.Proctime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProctimeMapper {
    int deleteByPrimaryKey(@Param("partno") String partno, @Param("machineno") String machineno);

    int insert(Proctime record);

    Proctime selectByPrimaryKey(@Param("partno") String partno, @Param("machineno") String machineno);

    List<Proctime> selectAll();

    int updateByPrimaryKey(Proctime record);
}