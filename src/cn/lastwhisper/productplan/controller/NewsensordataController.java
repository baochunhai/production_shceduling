package cn.lastwhisper.productplan.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import cn.lastwhisper.productplan.pojo.Newsensordata;
import cn.lastwhisper.productplan.service.NewsensordataService;
import cn.lastwhisper.productplan.service.NewsensordataService;

/**
 * 生产计划
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/proPlane")
public class NewsensordataController {

	@Autowired
	private NewsensordataService newsensordataService;
	
	
	 @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	//wisdom/proSensordata/sensordata/sensordatalistByPage
	@RequestMapping(value = "/sensordatalistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult sensordatalistByPage(Newsensordata sensordata,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return newsensordataService.findSensordatalistByPage(sensordata, page, rows);
	}
	
	/**
	 * 
	 * @Title: 
	 * @Description: 根据user封装的条件删除用户
	 * @param user 封装的条件
	 * @return
	 */
	@RequestMapping(value = "/sensordatadelete", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult sensordatadelete(Newsensordata sensordata) {
		return newsensordataService.deleteSensordata(sensordata.getRecorddate(),sensordata.getMpsno(),sensordata.getProcessno());
	}
	
}
