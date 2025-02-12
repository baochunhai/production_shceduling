package cn.lastwhisper.product.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.core.util.Tree;
import cn.lastwhisper.knowledge.service.Menu2Service;
import cn.lastwhisper.product.pojo.Gaselectedmpsno;
import cn.lastwhisper.product.service.GASelectedMPSNoService;
import cn.lastwhisper.productplan.mapper.ProcessMapper;
import cn.lastwhisper.productplan.pojo.Equipmentintegrity;
import cn.lastwhisper.productplan.pojo.Machine;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Newsensordata;
import cn.lastwhisper.productplan.pojo.Process;
import cn.lastwhisper.productplan.service.DeviceFaultService;
import cn.lastwhisper.productplan.service.EquipmentintegrityService;
import cn.lastwhisper.productplan.service.MpsService;
import cn.lastwhisper.productplan.service.NewsensordataService;
import cn.lastwhisper.productplan.service.ProcessService;

/**
 * 生产计划
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apps/product")
public class SelectController {

	@Autowired
	private MpsService mpsService;
	@Autowired
	private GASelectedMPSNoService gASelectedMPSNoService;
	@Autowired
	private Menu2Service menuService;
	@Autowired
	public DeviceFaultService deviceFaultService;
	@Autowired
	private NewsensordataService newsensordataService;
	@Autowired
	private EquipmentintegrityService equipmentintegrityService;
	@Autowired
	private ProcessService processService;
	
	
	
	
	 @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	//wisdom/proPlane/mps/planelistByPage
	@RequestMapping(value = "/selectlistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult planelistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return mpsService.findPlanelistByPage(mps, page, rows);
	}
	
	//wisdom/proPlane/mps/planelistByPage
		@RequestMapping(value = "/selectlistByPageSolved", method = RequestMethod.POST)
		@ResponseBody
		public EasyUIDataGridResult planelistByPageSolved(Mps mps,
				@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
				@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
			return mpsService.findPlanelistByPageSolved(mps, page, rows);
		}
	/**
	 * 
	 * @Title: 
	 * @Description: 根据user封装的条件删除用户
	 * @param user 封装的条件
	 * @return
	 */
	@RequestMapping(value = "/planedelete", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult planedelete(Mps mps) {
		return mpsService.deletePlane(mps.getMpsno());
	}
	/**
	 * 选择工件
	 * @param menu
	 * @param machineno
	 * @return
	 */
	@RequestMapping(value="/addGA")
	@ResponseBody
	public GlobalResult insert(@RequestBody List<Gaselectedmpsno> list) {
		return gASelectedMPSNoService.addGA(list);
	}
	/**
	 * 1.插单列表
	 * @param mps
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/insertlistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult insertlistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return mpsService.findInsertlistByPage(mps, page, rows);
	}
	/**
	 * 2.生产进度延期列表
	 * @param mps
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/delaylistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult delaylistByPage(Process process,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		String delaytime = process.getActualstarttime();
		return processService.findProcessdelaylistByPage(delaytime, page, rows);
	}
	/**
	 * 3.设备故障列表
	 * @param mps
	 * @param page
	 * @param rows
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/faultlistByPage", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public EasyUIDataGridResult faultlistByPage(Machine machine,
	 * 
	 * @RequestParam(value = "page", required = true, defaultValue = "1") Integer
	 * page,
	 * 
	 * @RequestParam(value = "rows", required = true, defaultValue = "10") Integer
	 * rows) { return deviceFaultService.findMachinelistByPage(machine, page, rows);
	 * }
	 */
	/**
	 * 4.齐套性问题列表
	 * @param mps
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/completelistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult completelistByPage(Equipmentintegrity equipmentintegrity,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return equipmentintegrityService.findEquiplistByPage(equipmentintegrity, page, rows);
	}
	/**
	 * 插单
	 * @param list
	 * @return
	 */
	@RequestMapping(value="/insertGA")
	@ResponseBody
	public GlobalResult insertGA(@RequestBody List<Gaselectedmpsno> list) {
		return gASelectedMPSNoService.insertGA(list);
	}
	/**
	 * 设备故障录入
	 * @param list
	 * @return
	 */
	@RequestMapping(value="/insertFault")
	@ResponseBody
	public GlobalResult insertFault(@RequestParam String machineno,@RequestParam String precovertime) {
		return gASelectedMPSNoService.insertFault(machineno,precovertime);
	}
	
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
}
