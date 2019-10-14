package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Process;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessMapper {
    int deleteByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno);

    int insert(Process record);

    Process selectByPrimaryKey(@Param("mpsno") String mpsno, @Param("processno") String processno);

    List<Process> selectAll();

    int updateByPrimaryKey(Process record);
    
    public List<Process> selectProcesslistByPage(Process record);
    public List<Process> selectProcessdelaylistByPage(@Param("delaytime") String delaytime);//生产设备延期
   List<Mps> selectMps();
   List<Mps> processCompleteMps();
   List<Process> getProcessNo(@Param("mpsno") String mpsno);
   
   public List<Process> selectPredictlistByPage(Mps record);
   public List<Process> selectManuePlanelistByPage(Mps record);
}