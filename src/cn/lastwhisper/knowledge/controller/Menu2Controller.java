/**  
 * @Title:  MenuController.java   
 * @Package cn.lastwhisper.controller   
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 鲍春海     
 * @date:   2019年4月6日 下午5:05:32   
 * @version V1.0 
 */
package cn.lastwhisper.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.core.util.Tree;
import cn.lastwhisper.core.util.UserUtils;
import cn.lastwhisper.knowledge.pojo.Carbonknowledge;
import cn.lastwhisper.knowledge.service.Menu2Service;
import cn.lastwhisper.modular.pojo.Menu;
import cn.lastwhisper.modular.pojo.User;

/**   
 * @ClassName:  MenuController   
 * @Description:菜单管理
 * @author:     鲍春海
 * @date:       2019年4月6日
 */
@Controller
@RequestMapping("/apps/knowledge")
public class Menu2Controller {
	
	@Autowired
	private Menu2Service menuService;
	/**
	 * 查找所有
	 * @author Zoe
	 * @date 2019年2月15日下午3:46:48
	 * @return
	 */
	@RequestMapping(value="/menu/menulist")
	@ResponseBody
	public List<Tree> findAll(String type) {
		return menuService.findMenuList(type); 
	}
	
	/**
	 * 根据菜单id查找菜单，显示菜单详情
	 * @author Zoe
	 * @date 2019年2月15日下午8:15:02
	 * @param menuid 主键
	 * @return
	 */
	@RequestMapping("/menu/menufindById")
	@ResponseBody
	public List findById(String type,String processno) {
		return menuService.findMenuById(type,processno);
	}
	
	@RequestMapping("/menu/knowledge")
	@ResponseBody
	public List knowledge(String type,String processno) {
		return menuService.findClob(type,processno);
	}
	
	/**
	 * 添加数据
	 * @author Zoe
	 * @date 2019年2月15日下午9:47:56
	 * @param menu 菜单对象
	 * @return
	 */
	@RequestMapping(value="/menu/menuadd")
	@ResponseBody
	public GlobalResult insert(Carbonknowledge menu,String machineno) {
		return menuService.addMenu(menu,machineno);
	}
	
	/**
	 * 根据id删除数据[修改状态]
	 * @author Zoe
	 * @date 2019年2月15日下午9:47:41
	 * @param menuid 主键
	 * @return
	 */
	@RequestMapping(value="/menu/menudelete")
	@ResponseBody
	public GlobalResult deleteById(String menuid) {
		return menuService.deleteMenuById(menuid);
	}
	
	/**
	 * 根据id修改数据
	 * @author Zoe
	 * @date 2019年2月15日下午9:48:22
	 * @param menu 菜单对象
	 * @return
	 */
	@RequestMapping(value="/menu/menuupdate")
	@ResponseBody
	public GlobalResult updateById(Carbonknowledge menu) {
		
		
		return menuService.updateMenuById(menu);
	}
	
	
	/**
	 * 
	* @Title: loadMenu 
	* @Description: 根据session中的user_id加载菜单
	* @return Menu
	* @author 鲍春海
	* @date 2019年2月16日下午9:18:20
	 */
	@RequestMapping(value="/menu/loadMenus")
	@ResponseBody
	public Menu loadMenus() {
		User user = UserUtils.getSessionUser();
		Menu menus = null;
		if(user!=null) {
			menus = menuService.findMenuByUserid(user.getUser_id());
		}
		return menus;
	}
}
