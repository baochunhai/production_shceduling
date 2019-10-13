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
public class ProductController {

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
	@RequestMapping(value = "/schedulinglistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult schedulinglistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return gASelectedMPSNoService.findSchedulinglistByPage(mps, page, rows);
	}
	
	@RequestMapping(value="/calculate")
	@ResponseBody
	public GlobalResult calculate(@RequestBody List<Mps> list) {
		
		return gASelectedMPSNoService.calculate(list);
	}
	/**
	 * 排产后查询
	 * @param mps
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/loadProductlistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult loadProductlistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return gASelectedMPSNoService.loadProductlistByPage(mps, page, rows);
	}
	
	/**
	 * 排产后查询
	 * @param mps
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/savecomplete", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult savecomplete(@RequestParam String mpsno,@RequestParam String processno,@RequestParam 
			String precoverytime) {
		return equipmentintegrityService.addEquipComplete(mpsno,processno,precoverytime);
	}
}
