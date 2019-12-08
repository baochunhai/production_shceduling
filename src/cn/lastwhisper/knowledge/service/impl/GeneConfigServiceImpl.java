package cn.lastwhisper.knowledge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.knowledge.mapper.GeneticMapper;
import cn.lastwhisper.knowledge.pojo.Genetic;
import cn.lastwhisper.knowledge.service.GeneConfigService;

@Service
public class GeneConfigServiceImpl implements GeneConfigService {

	@Autowired
	private GeneticMapper geneticMapper;
	
	@Override
	public GlobalResult configSave(Genetic record) {
		// TODO Auto-generated method stub
		GlobalResult global = new GlobalResult();
		try {
			geneticMapper.delete();
			int count = geneticMapper.insert(record);
			if(count==1) {
				global.setData("");
				global.setMsg("保存成功");
				global.setStatus(200);
				return global; 
			}else {
				global.setData("");
				global.setMsg("保存失败");
				global.setStatus(200);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return global;
	}

	@Override
	public Genetic configSelect() {
		// TODO Auto-generated method stub
		return geneticMapper.selectAll().get(0);
	}

}
