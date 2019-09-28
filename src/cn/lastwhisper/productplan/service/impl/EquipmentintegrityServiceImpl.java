package cn.lastwhisper.productplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.productplan.mapper.EquipmentintegrityMapper;
import cn.lastwhisper.productplan.pojo.Equipmentintegrity;
import cn.lastwhisper.productplan.service.EquipmentintegrityService;

@Service
public class EquipmentintegrityServiceImpl implements EquipmentintegrityService {
	
	@Autowired
	private EquipmentintegrityMapper equipMapper;
	
	@Override
	public EasyUIDataGridResult findEquiplistByPage(Equipmentintegrity equipmentintegrity, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		
		List<Equipmentintegrity> list = equipMapper.selectEquiplistByPage(equipmentintegrity);
		PageInfo<Equipmentintegrity> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public GlobalResult addEquip(Equipmentintegrity equipmentintegrity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GlobalResult updateEquip(Equipmentintegrity equipmentintegrity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GlobalResult deleteEquip(String mspno) {
		// TODO Auto-generated method stub
		return null;
	}

}
