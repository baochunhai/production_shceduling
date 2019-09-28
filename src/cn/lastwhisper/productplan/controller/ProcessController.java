package cn.lastwhisper.productplan.controller;

import java.text.DateFormat;
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
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.service.ProcessService;
import cn.lastwhisper.productplan.pojo.Process;
import cn.lastwhisper.productplan.pojo.Mps;
/**
 * 生产计划
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apps/proPlane")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	
	
	 @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	//wisdom/proPlane/mps/processlistByPage
	@RequestMapping(value = "/processlistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult processlistByPage(Process process,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return processService.findProcesslistByPage(process, page, rows);
	}
	
	/**
	 * 
	 * @Title: 
	 * @Description: 根据user封装的条件删除用户
	 * @param user 封装的条件
	 * @return
	 */
	@RequestMapping(value = "/processdelete", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult processdelete(Process mps) {
		return processService.deleteProcess(mps.getMpsno(),mps.getProcessno());
	}
	
	@RequestMapping(value = "/processAllMps", method = RequestMethod.POST)
	@ResponseBody
	public List<Mps> processAllMps() {
		return processService.selectMps();
	}
	
}
