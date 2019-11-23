package cn.lastwhisper.knowledge.service;

import java.util.List;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.core.util.Tree;
import cn.lastwhisper.modular.pojo.Menu;
import cn.lastwhisper.productplan.pojo.Carbonknowledge;

public interface Menu2Service {

	/**
	 * 
	 * @Title: findMenuList   
	 * @Description: 查找所有数据
	 * @author: 鲍春海   
	 * @return
	 */
	List<Tree> findMenuList(String menuid);

	/**
	 * 
	 * @Title: findMenuById   
	 * @Description: 根据菜单id查找菜单，显示菜单详情
	 * @author: 鲍春海    
	 * @param menuid
	 * @return
	 */
	List findMenuById(String menuid,String processno);

	List findClob(String menuid,String processno);
	/**
	 * 
	 * @Title: addMenu   
	 * @Description: 添加数据
	 * @author: 鲍春海    
	 * @param Menu
	 * @return
	 */
	GlobalResult addMenu(Carbonknowledge menu,String machineno);
	
	/**
	 * 
	 * @Title: deleteMenuById   
	 * @Description: 根据id删除数据
	 * @author: 鲍春海    
	 * @param menuid
	 * @return
	 */
	GlobalResult deleteMenuById(String menuid);

	/**
	 * 
	 * @Title: updateMenuById   
	 * @Description: 根据id修改数据
	 * @author: 鲍春海    
	 * @param Menu
	 * @return
	 */
	GlobalResult updateMenuById(Carbonknowledge Menu);
	/**
	 * 
	* @Title: findMenuByUserid 
	* @Description: 根据userid加载对应菜单 
	* @param userid
	* @return Menu
	* @author gj
	* @date 2019年2月16日下午8:43:39
	 */
	Menu findMenuByUserid(Integer userid);
	/**
	 * 
	* @Title: findMenuListByUserid 
	* @Description: 根据userid加载对应菜单无序列表 
	* @param userid
	* @return List<Menu>
	* @author gj
	* @date 2019年2月17日下午8:55:10
	 */
	List<Menu> findMenuListByUserid(Integer userid);

}
