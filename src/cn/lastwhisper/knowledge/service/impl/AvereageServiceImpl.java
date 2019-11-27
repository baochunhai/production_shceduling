package cn.lastwhisper.knowledge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.knowledge.service.AvereageService;
import cn.lastwhisper.productplan.mapper.CarbonknowledgeMapper;
import cn.lastwhisper.productplan.pojo.Carbonknowledge;

@Service
public class AvereageServiceImpl implements AvereageService {
	
	@Autowired
	private CarbonknowledgeMapper carbonKnowledge;
	
	@Override
	public List<String> cavelistByPage(Carbonknowledge type) {
		
		return carbonKnowledge.selectCave(type);
	}

	@Override
	public List<String> aavelistByPage(Carbonknowledge type) {
		// TODO Auto-generated method stub
		return carbonKnowledge.selectAave(type);
	}

	@Override
	public GlobalResult update(Carbonknowledge type) {
		int i = carbonKnowledge.update(type);
		GlobalResult result = new GlobalResult();
		if(i==0) {
			result.setStatus(300);
			result.setMsg("更新失败！");
		}else {
			result.setStatus(200);
			result.setMsg("更新成功！");
		}
		
		return result;
	}

}
