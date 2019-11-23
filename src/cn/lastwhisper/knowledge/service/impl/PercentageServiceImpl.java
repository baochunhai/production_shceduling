package cn.lastwhisper.knowledge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lastwhisper.knowledge.service.PercentageService;
import cn.lastwhisper.productplan.mapper.MachineMapper;

@Service
public class PercentageServiceImpl implements PercentageService {

	@Autowired
	private MachineMapper machineMapper;
	
	@Override
	public List queryPercentage() {
		// TODO Auto-generated method stub
		return machineMapper.queryPercentage();
	}

}
