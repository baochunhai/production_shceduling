package cn.lastwhisper.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.product.service.FaultyMachineService;
import cn.lastwhisper.productplan.mapper.FaultymachineMapper;
import cn.lastwhisper.productplan.pojo.Faultymachine;

@Service
public class FaultyMachineServiceImpl implements FaultyMachineService {

	@Autowired
	private FaultymachineMapper faultyMachineMapper;
	
	@Override
	public EasyUIDataGridResult findFaultlistByPage(Faultymachine fault,Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Faultymachine> list =faultyMachineMapper.selectFault(fault);
		PageInfo<Faultymachine> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

}
