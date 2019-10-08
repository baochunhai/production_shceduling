package cn.lastwhisper.dataAyalyes.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.dataAyalyes.service.PredictService;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.MpsService;

/**
 * 生产计划
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apps/dataanalyze")
public class LaborPredictController {

	@Autowired
	private MpsService mpsService;

	@Autowired
	private PredictService predictService;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// wisdom/proPlane/mps/planelistByPage
	@RequestMapping(value = "/planelistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult planelistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return mpsService.findPlanelistByPage(mps, page, rows);
	}

	/**
	 * 
	 * @Title:
	 * @Description:
	 * @param user 封装的条件
	 * @return
	 */
	@RequestMapping(value = "/planedelete", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult planedelete(Mps mps) {
		return mpsService.deletePlane(mps.getMpsno());
	}

	@RequestMapping(value = "/predictlistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult predictlistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows,HttpServletRequest req) {
		
		 String header = req.getHeader("Referer");
		 String string = header.substring(header.indexOf("=")+1);
		 mps.setMpsno(string);
		return predictService.findpredictlistByPage(mps, page, rows);
	}
}
