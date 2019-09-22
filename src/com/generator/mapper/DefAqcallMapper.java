package com.generator.mapper;

import com.generator.entity.DefAqcall;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefAqcallMapper {
    int deleteByPrimaryKey(@Param("enqTid") String enqTid, @Param("stepNo") BigDecimal stepNo);

    int insert(DefAqcall record);

    DefAqcall selectByPrimaryKey(@Param("enqTid") String enqTid, @Param("stepNo") BigDecimal stepNo);

    List<DefAqcall> selectAll();

    int updateByPrimaryKey(DefAqcall record);
}