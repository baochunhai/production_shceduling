package cn.lastwhisper.product.mapper;

import cn.lastwhisper.product.pojo.Gaschedule;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GascheduleMapper {
    int deleteByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("machineno") String machineno);

    int insert(Gaschedule record);

    Gaschedule selectByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno, @Param("machineno") String machineno);

    List<Gaschedule> selectAll();

    int updateByPrimaryKey(Gaschedule record);
    
    int insertMps(@Param("mpsno") String mpsno,@Param("pno") int pno);
    int updateByMpsnoo(Gaschedule record);
    int updateByMpsno(@Param("maxendtime")Double record);
    int deleteAll();
    String selectPartno();
    int deleteZero();
    
    int insertMpsPanel(@Param("mpsno")String mpsno,@Param("start")int start,@Param("end")int end);
    int updateProtime(Gaschedule record);
    
    int insertMpsHeart(@Param("mpsno")String mpsno,@Param("start")int start);
    int insertMpsQt(@Param("mpsno")String mpsno,@Param("start")int start);
}