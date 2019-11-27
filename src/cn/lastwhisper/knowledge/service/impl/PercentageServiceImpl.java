package cn.lastwhisper.knowledge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.knowledge.service.PercentageService;
import cn.lastwhisper.productplan.mapper.MachineMapper;
import cn.lastwhisper.productplan.pojo.Machine;

@Service
public class PercentageServiceImpl implements PercentageService {

	@Autowired
	private MachineMapper machineMapper;
	
	@Override
	public List queryPercentage() {
		// TODO Auto-generated method stub
		return machineMapper.queryPercentage();
	}

	@Override
	public GlobalResult percentageupdate(Machine machine) {
		int i = machineMapper.percentageupdate(machine);
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
