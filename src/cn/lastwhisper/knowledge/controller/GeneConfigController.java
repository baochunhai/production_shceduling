package cn.lastwhisper.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.knowledge.pojo.Genetic;
import cn.lastwhisper.knowledge.service.GeneConfigService;

@Controller
@RequestMapping("/apps/knowledge")
public class GeneConfigController {

	@Autowired
	private GeneConfigService geneConfigService;
	
	@RequestMapping(value="/configSave")
	@ResponseBody
	public GlobalResult configSave(Genetic type) {
		return geneConfigService.configSave(type); 
	}
	
	@RequestMapping(value="/configSelect")
	@ResponseBody
	public Genetic configSelect() {
		return geneConfigService.configSelect();
	}
	
}
