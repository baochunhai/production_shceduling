package com.generator.mapper;

import com.generator.entity.Gaschedule;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GascheduleMapper {
    int deleteByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("machineno") String machineno);

    int insert(Gaschedule record);

    Gaschedule selectByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("machineno") String machineno);

    List<Gaschedule> selectAll();

    int updateByPrimaryKey(Gaschedule record);
}