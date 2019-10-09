package cn.lastwhisper.product.service;

import cn.lastwhisper.core.util.EasyUIDataGridResult;

public interface FaultyMachineService {

	EasyUIDataGridResult findFaultlistByPage( Integer page, Integer rows);
}
