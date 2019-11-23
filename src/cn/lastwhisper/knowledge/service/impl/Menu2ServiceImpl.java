/**  
 * @Title:  MenuServiceImpl.java   
 * @Package cn.lastwhisper.service.impl   
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 最后的轻语_dd43     
 * @date:   2019年4月6日 下午5:10:31   
 * @version V1.0 
 */
package cn.lastwhisper.knowledge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import cn.lastwhisper.core.annotation.LogAnno;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.core.util.Tree;
import cn.lastwhisper.knowledge.mapper.CarbonmachineworkerMapper;
import cn.lastwhisper.knowledge.mapper.Menu2Mapper;
import cn.lastwhisper.knowledge.pojo.Carbonmachineworker;
import cn.lastwhisper.knowledge.service.Menu2Service;
import cn.lastwhisper.modular.pojo.Menu;
import cn.lastwhisper.productplan.mapper.CarbonknowledgeMapper;
import cn.lastwhisper.productplan.pojo.Carbonknowledge;

/**
 * @ClassName: MenuServiceImpl
 * @Description: 菜单相关的操作
 * @author: 鲍春海
 * @date: 2019年4月6日
 */
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
@Service
public class Menu2ServiceImpl implements Menu2Service {

	private static Logger logger = LoggerFactory.getLogger(Menu2ServiceImpl.class);

	@Autowired
	private Menu2Mapper menu2Mapper;
	
	@Autowired
	private CarbonmachineworkerMapper carbonmachineworkerMapper;
	@Autowired
	private CarbonknowledgeMapper carbonknowledge;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public List<Tree> findMenuList(String menuid) {
		List<Tree> tree = menu2Mapper.selectMenuList(menuid);
		return tree;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public List findMenuById(String menuid,String processno) {
		return menu2Mapper.selectMenuById(menuid,processno);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public List findClob(String menuid,String processno) {
		return carbonknowledge.selectKnowledge(menuid,processno);
	}

	@Override
	public GlobalResult addMenu(Carbonknowledge menu,String machineno) {
		// 设置默认添加的菜单的状态为使用中
		Integer insertCount = carbonknowledge.insertKnowledge(menu);
		
		Carbonmachineworker record = new Carbonmachineworker();
		record.setProcessno(menu.getProcessno());
		record.setMachineno(machineno);
		record.setType(menu.getType());
		Integer insert = carbonmachineworkerMapper.insert(record);
		if (insertCount != null && insertCount > 0&&insert!=null&&insert>0) {
			return new GlobalResult(200, "数据添加成功", null);
		} else {
			return new GlobalResult(400, "数据添加失败", null);
		}
	}

	/**
	 * 根据id删除数据
	 * 
	 * @author
	 * @date 2019年2月15日下午9:51:50
	 * @param menuid 主键
	 * @return
	 */
	@Override
	public GlobalResult deleteMenuById(String menuid) {
		Integer deleteCount = menu2Mapper.deleteMenuById(menuid);
		if (deleteCount != null && deleteCount > 0) {
			return new GlobalResult(200, "数据删除成功", null);
		} else {
			return new GlobalResult(400, "数据删除失败", null);
		}
	}

	/**
	 * @author
	 * @date 2019年2月15日下午9:51:50
	 * @param menu
	 * @return
	 */
	@Override
	public GlobalResult updateMenuById(Carbonknowledge menu) {
		Integer updateCount = menu2Mapper.updateMenuById(menu);
		if (updateCount != null && updateCount > 0) {
			return new GlobalResult(200, "数据修改成功", null);
		} else {
			return new GlobalResult(400, "数据修改失败", null);
		}
	}

	/**
	 * 
	 * @Title: cloneMenu
	 * @Description: 复制menu
	 * @author: 最后的轻语_dd43
	 * @param src
	 * @return
	 */
	private Menu cloneMenu(Menu src) {
		Menu menu = new Menu();
		menu.setIcon(src.getIcon());
		menu.setMenuid(src.getMenuid());
		menu.setMenuname(src.getMenuname());
		menu.setUrl(src.getUrl());
		menu.setMenus(new ArrayList<Menu>());
		return menu;
	}

	@Override
	public Menu findMenuByUserid(Integer userid) {
		// 从缓存中读取数据
		Menu menu;
		// 获取根菜单
		List<Menu> root = menu2Mapper.selectMenu("-1");
		// 用户下的菜单集合 找数据库
		// List<Menu> userMenus = menu2Mapper.selectMenuByUserid(userid);
		// 用户下的菜单集合 找缓存
		List<Menu> userMenus = findMenuListByUserid(userid);
		// 根菜单
		menu = cloneMenu(root.get(0));
		// 暂存一级菜单
		Menu _m1 = null;
		// 暂存二级菜单
		Menu _m2 = null;
		// 获取全部的一级菜单
		List<Menu> parentMenus = menu2Mapper.selectMenu("0");
		// 循环一级菜单
		for (Menu m1 : parentMenus) {
			_m1 = cloneMenu(m1);
			// 获取当前一级菜单的所有二级菜单
			List<Menu> leafMenus = menu2Mapper.selectMenu(_m1.getMenuid());
			// 循环匹配二级菜单
			for (Menu m2 : leafMenus) {
				for (Menu userMenu : userMenus) {
					if (userMenu.getMenuid().equals(m2.getMenuid())) {
						// 将二级菜单加入一级菜单
						_m2 = cloneMenu(m2);
						_m1.getMenus().add(_m2);
					}
				}
			}
			// 有二级菜单我们才加进来
			if (_m1.getMenus().size() > 0) {
				// 把一级菜单加入到根菜单下
				menu.getMenus().add(_m1);
			}
		}
		logger.debug("从数据库读取，设置缓存");
		// System.out.println("从数据库读取，设置缓存");
		return menu;
	}

	@Override
	public List<Menu> findMenuListByUserid(Integer userid) {
		List<Menu> menuList;
		menuList = null;
		// 1.从数据库中查出来，放入缓存中
		menuList = menu2Mapper.selectMenuByUserid(userid);
		logger.debug("从数据库中查询menuList");
		// 2.直接从缓存中拿
		return menuList;
	}
}
