package cn.lastwhisper.dataAyalyes.service;

import java.util.List;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Process;

public interface PredictService {
	
	public EasyUIDataGridResult findpredictlistByPage(Mps process, Integer page, Integer rows);
	
	public GlobalResult addProcess(Process process);
	
	public GlobalResult updateProcess(Process process);
	
	public GlobalResult deleteProcess(String mpsno,String processno);
	
	
}
