package cn.lastwhisper.productplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.productplan.mapper.MachineMapper;
import cn.lastwhisper.productplan.pojo.Machine;
import cn.lastwhisper.productplan.service.DeviceFaultService;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService{
	
	
	@Autowired
	private MachineMapper machineMapper;
	
	@Override
	public EasyUIDataGridResult findMachinelistByPage(Machine machine, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Machine> list = machineMapper.selectMachinelistByPage(machine);
		PageInfo<Machine> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public List<Machine> findMachine() {
		return machineMapper.selectAll();
	}

}
