package cn.lastwhisper.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.product.mapper.SchedulingMapper;
import cn.lastwhisper.product.service.SchedulingService;

@Service
public class SchedulingServiceImpl implements SchedulingService{

	@Autowired
	private SchedulingMapper schedulingMapper;
	
	@Override
	public GlobalResult show(int count) {
		Integer scheduling = schedulingMapper.showScheduling();
		
		GlobalResult result = new GlobalResult();
		if(count==1) {
			result.setStatus(200);
			result.setMsg("success");
			result.setData(Integer.toString(scheduling));
		}else if(scheduling>count) {
			result.setStatus(200);
			result.setMsg("success");
			result.setData(Integer.toString(scheduling));
		}else {
			result.setStatus(400);
			result.setMsg("error");
			result.setData(Integer.toString(scheduling));
		}
		
		
		
		
		return result;
		
	}

	
}
