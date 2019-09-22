package com.generator.mapper;

import com.generator.entity.DefAqerror;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefAqerrorMapper {
    int deleteByPrimaryKey(@Param("enqTid") String enqTid, @Param("stepNo") BigDecimal stepNo);

    int insert(DefAqerror record);

    DefAqerror selectByPrimaryKey(@Param("enqTid") String enqTid, @Param("stepNo") BigDecimal stepNo);

    List<DefAqerror> selectAll();

    int updateByPrimaryKey(DefAqerror record);
}