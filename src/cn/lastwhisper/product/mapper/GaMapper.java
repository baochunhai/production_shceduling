package cn.lastwhisper.product.mapper;

import cn.lastwhisper.product.pojo.Ga;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GaMapper {
    int deleteByPrimaryKey(@Param("partno") BigDecimal partno, @Param("processno") String processno, @Param("machineno") String machineno);

    int insert(Ga record);
    int insertggA(Ga record);

    Ga selectByPrimaryKey(@Param("partno") BigDecimal partno, @Param("processno") String processno, @Param("machineno") String machineno);

    List<Ga> selectAll();

    int updateByPrimaryKey(Ga record);
    int updateProctime(Ga record);
}