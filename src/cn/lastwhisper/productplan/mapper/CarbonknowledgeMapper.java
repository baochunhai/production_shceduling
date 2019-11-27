package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Carbonknowledge;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CarbonknowledgeMapper {
    int deleteByPrimaryKey(String processno);

    int insert(Carbonknowledge record);

    Carbonknowledge selectByPrimaryKey(String processno);

    List<Carbonknowledge> selectAll();

    int updateByPrimaryKey(Carbonknowledge record);
    
    List selectAave(Carbonknowledge car);
    List selectCave(Carbonknowledge type);
    List selectKnowledge(@Param("type") String type,@Param("processno") String processno);
    
    /**
	 * 
	 * @Title: insertMenu   
	 * @Description: 添加数据
	 * @author: 鲍春海    
	 * @param Menu
	 * @return
	 */
	Integer insertKnowledge(Carbonknowledge Menu);
	
	int update(Carbonknowledge Menu);
}