package cn.lastwhisper.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.knowledge.service.PercentageService;
import cn.lastwhisper.productplan.pojo.Carbonknowledge;

@Controller
@RequestMapping("/apps/knowledge")
public class PercentageController {

	@Autowired
	private PercentageService percentageService;
	
	@RequestMapping(value="/percentagelistByPage")
	@ResponseBody
	public List cavelistByPage(Carbonknowledge type) {
		return percentageService.queryPercentage(); 
	}
	
}
