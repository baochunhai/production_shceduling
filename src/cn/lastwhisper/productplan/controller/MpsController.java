package cn.lastwhisper.productplan.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.MpsService;

/**
 * 生产计划
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apps/proPlane")
public class MpsController {

	@Autowired
	private MpsService mpsService;
	
	
	 @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	//wisdom/proPlane/mps/planelistByPage
	@RequestMapping(value = "/planelistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult planelistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		if(StringUtils.isNotEmpty(mps.getStartdate())) {
			mps.setStartdate(mps.getStartdate().replaceAll("-", ""));
		}
		if(StringUtils.isNotEmpty(mps.getEnddate())) {
			mps.setEnddate(mps.getEnddate().replaceAll("-", ""));
		}
		
		return mpsService.findPlanelistByPage(mps, page, rows);
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
	
	@RequestMapping(value = "/countMps", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult countMps(Mps mps) {
		return mpsService.countMps();
	}
	
}
