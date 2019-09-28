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
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Equipmentintegrity;
import cn.lastwhisper.productplan.service.EquipmentintegrityService;

@Controller
@RequestMapping("/apps/disturb")
public class EquipmentintegrityController {

	@Autowired
	private EquipmentintegrityService equipmentintegrityService;
	
	
	 @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	//wisdom/proPlane/mps/completenesslistByPage
	@RequestMapping(value = "/completenesslistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult completenesslistByPage(Equipmentintegrity equipmentintegrity,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows) {
		return equipmentintegrityService.findEquiplistByPage(equipmentintegrity, page, rows);
	}
	
	/**
	 * 
	 * @Title: 
	 * @Description: 
	 * @param  封装的条件
	 * @return
	 */
	@RequestMapping(value = "/completenessdelete", method = RequestMethod.POST)
	@ResponseBody
	public GlobalResult completenessdelete(Equipmentintegrity equipmentintegrity) {
		return equipmentintegrityService.deleteEquip(equipmentintegrity.getMpsno());
	}
	
}
