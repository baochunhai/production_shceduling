package com.generator.mapper;

import com.generator.entity.Gaparallel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GaparallelMapper {
    int deleteByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno, @Param("mpsno") String mpsno);

    int insert(Gaparallel record);

    Gaparallel selectByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno, @Param("mpsno") String mpsno);

    List<Gaparallel> selectAll();

    int updateByPrimaryKey(Gaparallel record);
}