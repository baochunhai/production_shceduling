package cn.lastwhisper.knowledge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
