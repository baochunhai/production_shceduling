package cn.lastwhisper.dataAyalyes.service;


import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Process;

public interface ManueResouceService {
	
	public EasyUIDataGridResult findmanuelistByPage(Mps process, Integer page, Integer rows);
	
	public GlobalResult addProcess(Process process);
	
	public GlobalResult updateProcess(Process process);
	
	public GlobalResult deleteProcess(String mpsno,String processno);
	
	
}
