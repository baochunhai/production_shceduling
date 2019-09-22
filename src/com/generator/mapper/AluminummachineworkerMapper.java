package com.generator.mapper;

import com.generator.entity.Aluminummachineworker;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AluminummachineworkerMapper {
    int deleteByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno);

    int insert(Aluminummachineworker record);

    List<Aluminummachineworker> selectAll();
}