package cn.lastwhisper.productplan.service;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Equipmentintegrity;

public interface EquipmentintegrityService {

	public EasyUIDataGridResult findEquiplistByPage(Equipmentintegrity equipmentintegrity, Integer page, Integer rows);

	public GlobalResult addEquip(Equipmentintegrity equipmentintegrity);

	public GlobalResult updateEquip(Equipmentintegrity equipmentintegrity);

	public GlobalResult deleteEquip(String mspno);
}
