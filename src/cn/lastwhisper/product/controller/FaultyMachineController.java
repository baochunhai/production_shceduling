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
import cn.lastwhisper.knowledge.pojo.Carbonknowledge;
import cn.lastwhisper.product.pojo.Gaselectedmpsno;
import cn.lastwhisper.product.service.FaultyMachineService;
import cn.lastwhisper.product.service.GASelectedMPSNoService;
import cn.lastwhisper.productplan.pojo.Faultymachine;
import cn.lastwhisper.productplan.pojo.Machine;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.DeviceFaultService;
import cn.lastwhisper.productplan.service.MpsService;

/**
 * 生产计划
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apps/product")
public class FaultyMachineController {

	@Autowired
	private FaultyMachineService faultyMachineService;
	
	@Autowired
	public DeviceFaultService deviceFaultService;
	 @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	 /**
		 * 3.设备故障列表
		 * @param mps
		 * @param page
		 * @param rows
		 * @return
		 */
	//wisdom/proPlane/mps/planelistByPage
	@RequestMapping(value = "/faultlistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult planelistByPage(Machine machine,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return deviceFaultService.findMachinelistByPage(machine, page, rows);
	}
	
}
