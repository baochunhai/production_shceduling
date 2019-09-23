package cn.lastwhisper.productplan.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.productplan.mapper.NewsensordataMapper;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.pojo.Newsensordata;
import cn.lastwhisper.productplan.service.NewsensordataService;

@Service
public class NewsensordataServiceImpl implements NewsensordataService{

	@Autowired
	private NewsensordataMapper newsensordataMapper;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public EasyUIDataGridResult findSensordatalistByPage(Newsensordata newsensordata, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<User> list = newsensordataMapper.selectSensordatalistByPage(newsensordata);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public GlobalResult addSensordata(Mps mps) {
		return null;
	}

	@Override
	public GlobalResult updateSensordata(Mps msp) {
		return null;
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public GlobalResult deleteSensordata(@Param("recorddate") String recorddate, @Param("mpsno") String mpsno, @Param("processno") String processno) {
		int count = newsensordataMapper.deleteByPrimaryKey(recorddate,mpsno, processno);
		if(count==0) {
			return new GlobalResult(400, "生产计划删除失败", null);
		}else {
			return new GlobalResult(400, "生产计划删除成功", null);
		}
	}
}
