package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Equipmentintegrity;
import cn.lastwhisper.productplan.pojo.Mps;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentintegrityMapper {
    int deleteByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("fstarttime") String fstarttime);

    int insert(Equipmentintegrity record);

    Equipmentintegrity selectByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("fstarttime") String fstarttime);

    List<Equipmentintegrity> selectAll();

    int updateByPrimaryKey(Equipmentintegrity record);
    
    public List<Equipmentintegrity> selectEquiplistByPage(Equipmentintegrity equipmentintegrity);
}