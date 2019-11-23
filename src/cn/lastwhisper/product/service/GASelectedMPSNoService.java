package cn.lastwhisper.product.service;

import java.util.List;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.product.pojo.Gaselectedmpsno;
import cn.lastwhisper.productplan.pojo.Equipmentintegrity;
import cn.lastwhisper.productplan.pojo.Mps;

public interface GASelectedMPSNoService {

	public GlobalResult addGA(List<Gaselectedmpsno> mps);
	
	public GlobalResult insertGA(List<Gaselectedmpsno> mps);
	public GlobalResult insertFault(String machineno,String precovertime);
	
	public EasyUIDataGridResult findSchedulinglistByPage(Mps mps, Integer page, Integer rows);
	
	public  GlobalResult calculate(List<Mps> mps);
	
	public EasyUIDataGridResult loadProductlistByPage(Mps mps, Integer page, Integer rows);
	public EasyUIDataGridResult lastProductlistByPage(Mps mps, Integer page, Integer rows);
}
