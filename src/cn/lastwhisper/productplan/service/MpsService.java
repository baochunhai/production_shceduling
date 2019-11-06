package cn.lastwhisper.productplan.service;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Mps;

public interface MpsService {

	public EasyUIDataGridResult findPlanelistByPage(Mps mps, Integer page, Integer rows);
	public EasyUIDataGridResult findPlanelistByPageSolved(Mps mps, Integer page, Integer rows);
	
	public GlobalResult addPlane(Mps mps);
	
	public GlobalResult updatePlane(Mps msp);
	
	public GlobalResult deletePlane(String mpsno);
	
	public EasyUIDataGridResult findInsertlistByPage(Mps mps, Integer page, Integer rows);
	public EasyUIDataGridResult selectInsertShowlistByPage(Mps mps, Integer page, Integer rows);
}
