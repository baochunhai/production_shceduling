package cn.lastwhisper.productplan.service;

import org.apache.ibatis.annotations.Param;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Newsensordata;

public interface NewsensordataService {

	public EasyUIDataGridResult findSensordatalistByPage(Newsensordata newsensordata, Integer page, Integer rows);
	
	public GlobalResult addSensordata(Mps mps);
	
	public GlobalResult updateSensordata(Mps msp);
	
	public GlobalResult deleteSensordata(@Param("recorddate") String recorddate, @Param("mpsno") String mpsno, @Param("processno") String processno);
}
