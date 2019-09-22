package com.generator.mapper;

import com.generator.entity.Ga;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GaMapper {
    int deleteByPrimaryKey(@Param("partno") BigDecimal partno, @Param("processno") String processno, @Param("machineno") String machineno);

    int insert(Ga record);

    Ga selectByPrimaryKey(@Param("partno") BigDecimal partno, @Param("processno") String processno, @Param("machineno") String machineno);

    List<Ga> selectAll();

    int updateByPrimaryKey(Ga record);
}