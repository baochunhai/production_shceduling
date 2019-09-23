package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.productplan.pojo.Mps;
import java.util.List;

public interface MpsMapper {
    int deleteByPrimaryKey(String mpsno);

    int insert(Mps record);

    Mps selectByPrimaryKey(String mpsno);

    List<Mps> selectAll();

    int updateByPrimaryKey(Mps record);
    
    /**
	 * 
	 * @Title: selectPlaneList   
	 * @Description: 查询所有生产计划
	 * @param user 查询条件
	 * @return
	 */
	public List<User> selectPlanelistByPage(Mps mps);
}