package cn.lastwhisper.productplan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.productplan.mapper.MpsMapper;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.MpsService;

@Service
public class MpsServiceImpl implements MpsService{

	@Autowired
	private MpsMapper mpsMapper;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public EasyUIDataGridResult findPlanelistByPage(Mps mps, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Mps> list = mpsMapper.selectPlanelistByPage(mps);
		PageInfo<Mps> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}
	/**
	 * 工件排产选择的工件
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public EasyUIDataGridResult findPlanelistByPageSolved(Mps mps, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Mps> list = mpsMapper.selectPlanelistByPageSolved(mps);
		PageInfo<Mps> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}
	@Override
	public GlobalResult addPlane(Mps mps) {
		return null;
	}

	@Override
	public GlobalResult updatePlane(Mps msp) {
		int count = mpsMapper.updateByPrimaryKey(msp);
		return null;
	}

	@Override
	public GlobalResult deletePlane(String mpsno) {
		
		int count = mpsMapper.deleteByPrimaryKey(mpsno);
		if(count==0) {
			return new GlobalResult(400, "生产计划删除失败", null);
		}else {
			return new GlobalResult(400, "生产计划删除成功", null);
		}
		
		
	}

	@Override
	public EasyUIDataGridResult findInsertlistByPage(Mps mps, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Mps> list = mpsMapper.selectInsertlistByPage(mps);
		PageInfo<Mps> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public EasyUIDataGridResult selectInsertShowlistByPage(Mps mps, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Mps> list = mpsMapper.selectInsertShowlistByPage(mps);
		PageInfo<Mps> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}
	@Override
	public GlobalResult countMps() {
		GlobalResult result = new GlobalResult();
		try {
			List<Map<String, Integer>> countMps = mpsMapper.countMps();
			if (countMps != null && countMps.size() > 0) {
				result.setStatus(200);
				result.setData(countMps);
				result.setMsg("success");
			} else {
				result.setStatus(400);
				result.setMsg("error");
				result.setData(null);
			}
		} catch (Exception e) {
			result.setStatus(400);
			result.setData(e.getStackTrace());
			result.setMsg("error");
		}
		return result;
	}
}