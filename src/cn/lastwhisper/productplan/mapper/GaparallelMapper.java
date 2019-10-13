package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Gaparallel;
import cn.lastwhisper.productplan.pojo.Mps;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GaparallelMapper {
    int deleteByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno, @Param("mpsno") String mpsno);

    int insert(Gaparallel record);

    Gaparallel selectByPrimaryKey(@Param("processno") String processno, @Param("machineno") String machineno, @Param("mpsno") String mpsno);

    List<Gaparallel> selectAll();

    int updateByPrimaryKey(Gaparallel record);
    
    int deleteAll();
    
    int insertPall();
    //显示排产结果
    public List selectGASchedlelistByPage(Mps mps);
    
}