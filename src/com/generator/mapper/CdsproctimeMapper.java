package com.generator.mapper;

import com.generator.entity.Cdsproctime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CdsproctimeMapper {
    int deleteByPrimaryKey(@Param("partno") String partno, @Param("machineno") String machineno);

    int insert(Cdsproctime record);

    Cdsproctime selectByPrimaryKey(@Param("partno") String partno, @Param("machineno") String machineno);

    List<Cdsproctime> selectAll();

    int updateByPrimaryKey(Cdsproctime record);
}