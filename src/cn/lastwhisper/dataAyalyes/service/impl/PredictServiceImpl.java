package cn.lastwhisper.dataAyalyes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.dataAyalyes.service.PredictService;
import cn.lastwhisper.productplan.mapper.ProcessMapper;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Process;

@Service
public class PredictServiceImpl implements PredictService{

	@Autowired
	private ProcessMapper processMapper;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public EasyUIDataGridResult findpredictlistByPage(Mps process, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Process> list = processMapper.selectPredictlistByPage(process);
		PageInfo<Process> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public GlobalResult addProcess(Process process) {
		return null;
	}

	@Override
	public GlobalResult updateProcess(Process msp) {
		return null;
	}

	@Override
	public GlobalResult deleteProcess(String mpsno,String processno) {
		
		int count = processMapper.deleteByPrimaryKey(mpsno,processno);;
		if(count==0) {
			return new GlobalResult(400, "生产计划删除失败", null);
		}else {
			return new GlobalResult(400, "生产计划删除成功", null);
		}
		
		
	}

}
