package cn.lastwhisper.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.knowledge.service.AvereageService;
import cn.lastwhisper.productplan.pojo.Carbonknowledge;

@Controller
@RequestMapping("/apps/knowledge")
public class AverageController {
	
	@Autowired
	private AvereageService avereageService;
	
	@RequestMapping(value="/cavelistByPage")
	@ResponseBody
	public List cavelistByPage(Carbonknowledge type) {
		return avereageService.aavelistByPage(type); 
	}
	
	@RequestMapping(value="/aavelistByPage")
	@ResponseBody
	public List aavelistByPage(Carbonknowledge type) {
		return avereageService.cavelistByPage(type); 
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	public GlobalResult update(Carbonknowledge type) {
		return avereageService.update(type); 
	}
}
