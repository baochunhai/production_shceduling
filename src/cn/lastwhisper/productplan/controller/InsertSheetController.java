package cn.lastwhisper.productplan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.MpsService;

/**
 * 插单管理处理类
 * @author wuxk
 *
 */
@Controller
@RequestMapping("/apps/insertsheet")
public class InsertSheetController {

	@Autowired
	private MpsService mpsService;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/planelistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult planelistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		//List<Mps> list = (List<Mps>)mpsService.findPlanelistByPage(mps, page, rows).getRows();
		return mpsService.findPlanelistByPage(mps, page, rows);
	}
}
