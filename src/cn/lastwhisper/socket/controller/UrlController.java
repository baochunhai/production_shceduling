package cn.lastwhisper.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.product.service.SchedulingService;

@Controller
public class UrlController {

	
	 @Autowired private SchedulingService schedulingService;
	  
	  @RequestMapping(value = "showscheduling", method = RequestMethod.POST)
	 
	  @ResponseBody public GlobalResult show(String count) {
	 
	  return schedulingService.show(Integer.parseInt(count)); }
	 
}
