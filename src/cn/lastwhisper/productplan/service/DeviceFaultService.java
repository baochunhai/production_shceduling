package cn.lastwhisper.productplan.service;

import java.util.List;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.productplan.pojo.Machine;

public interface DeviceFaultService {
	public EasyUIDataGridResult findMachinelistByPage(Machine machine, Integer page, Integer rows);
	public List<Machine> findMachine();
}
