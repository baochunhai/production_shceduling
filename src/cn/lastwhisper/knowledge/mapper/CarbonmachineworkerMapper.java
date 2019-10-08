package cn.lastwhisper.knowledge.mapper;

import cn.lastwhisper.knowledge.pojo.Carbonmachineworker;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarbonmachineworkerMapper {
    int deleteByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno, @Param("type") String type);

    int insert(Carbonmachineworker record);

    List<Carbonmachineworker> selectAll();
}