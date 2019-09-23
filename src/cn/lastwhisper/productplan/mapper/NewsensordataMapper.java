package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Newsensordata;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsensordataMapper {
    int deleteByPrimaryKey(@Param("recorddate") String recorddate, @Param("mpsno") String mpsno, @Param("processno") String processno);

    int insert(Newsensordata record);

    Newsensordata selectByPrimaryKey(@Param("recorddate") String recorddate, @Param("mpsno") String mpsno, @Param("processno") String processno);

    List<Newsensordata> selectAll();

    int updateByPrimaryKey(Newsensordata record);
    
    /**
  	 * 
  	 * @Title: selectPlaneList   
  	 * @Description: 查询所有生产计划
  	 * @param user 查询条件
  	 * @return
  	 */
  	public List<User> selectSensordatalistByPage(Newsensordata newsensordata);
}