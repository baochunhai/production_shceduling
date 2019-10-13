package cn.lastwhisper.product.service;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.productplan.pojo.Faultymachine;

public interface FaultyMachineService {

	EasyUIDataGridResult findFaultlistByPage(Faultymachine fault, Integer page, Integer rows);
}
