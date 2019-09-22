package com.generator.mapper;

import com.generator.entity.Carbonmachineworker;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarbonmachineworkerMapper {
    int deleteByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno);

    int insert(Carbonmachineworker record);

    List<Carbonmachineworker> selectAll();
}