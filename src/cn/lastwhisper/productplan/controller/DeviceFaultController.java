package cn.lastwhisper.productplan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.productplan.pojo.Machine;
import cn.lastwhisper.productplan.service.DeviceFaultService;


/**
 * 设备故障处理类
 * @author wuxk
 *
 */
@Controller
@RequestMapping("/apps/devicefault")
public class DeviceFaultController {
	
	@Autowired
	public DeviceFaultService deviceFaultService;
	
	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/machinelistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult machinelistByPage(Machine machine,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return deviceFaultService.findMachinelistByPage(machine, page, rows);
	}
	@RequestMapping(value = "/machinenoAllMps", method = RequestMethod.POST)
	@ResponseBody
	public List<Machine> machinenoAllMps() {
		return deviceFaultService.findMachine();
	}
	
}
