package cn.lastwhisper.productplan.service;

import java.util.List;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Process;

public interface ProcessService {

	public EasyUIDataGridResult findProcesslistByPage(Process process, Integer page, Integer rows);
	
	public GlobalResult addProcess(Process process);
	
	public GlobalResult updateProcess(Process process);
	
	public GlobalResult deleteProcess(String mpsno,String processno);
	
	public List<Mps> selectMps();
	
	public EasyUIDataGridResult findProcessdelaylistByPage(String delaytime, Integer page, Integer rows);
	
}
