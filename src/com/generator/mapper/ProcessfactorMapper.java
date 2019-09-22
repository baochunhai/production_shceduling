package com.generator.mapper;

import com.generator.entity.Processfactor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessfactorMapper {
    int deleteByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("factorname") String factorname, @Param("factorvalue") String factorvalue);

    int insert(Processfactor record);

    List<Processfactor> selectAll();
}