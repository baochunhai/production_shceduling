package cn.lastwhisper.dataAyalyes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.dataAyalyes.service.ManueResouceService;
import cn.lastwhisper.productplan.pojo.Mps;

@Controller
@RequestMapping("/apps/dataanalyze")
public class ManueResourceConfigController {

	@Autowired
	private ManueResouceService manueResouceService;

	@RequestMapping(value = "/manue_planelistByPage", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult manue_planelistByPage(Mps mps,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows, HttpServletRequest req) {

		String header = req.getHeader("Referer");
		String string = header.substring(header.indexOf("=") + 1);
		mps.setMpsno(string);
		return manueResouceService.findmanuelistByPage(mps, page, rows);
	}
}
