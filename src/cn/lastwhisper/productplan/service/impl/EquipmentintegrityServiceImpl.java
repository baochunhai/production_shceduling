package cn.lastwhisper.productplan.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.product.mapper.GaMapper;
import cn.lastwhisper.product.pojo.Ga;
import cn.lastwhisper.productplan.mapper.EquipmentintegrityMapper;
import cn.lastwhisper.productplan.pojo.Equipmentintegrity;
import cn.lastwhisper.productplan.pojo.Faultymachine;
import cn.lastwhisper.productplan.service.EquipmentintegrityService;

@Service
public class EquipmentintegrityServiceImpl implements EquipmentintegrityService {
	
	@Autowired
	private EquipmentintegrityMapper equipMapper;
	@Autowired
	private GaMapper gaMppper;
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

	@Override
	public GlobalResult addEquipComplete(String mpsno, String processno, String precoverytime) {
		try {
			Ga ga = new Ga();
			ga.setMpsno(mpsno);
			ga.setProctime(Integer.parseInt(precoverytime));
			gaMppper.updateProctime(ga);
			Equipmentintegrity eq = new Equipmentintegrity();
			eq.setMpsno(mpsno);
			eq.setProcessno(processno);
			Date date = new Date(); //获取当前的系统时间。
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss") ; //使用了默认的格式创建了一个日期格式化对象。
			String time = dateFormat.format(date); //可以把日期转换转指定格式的字符串
			eq.setFstarttime(time);
			eq.setPrecoverytime(precoverytime);
			eq.setFendtime("");
			eq.setFdescription("IntegrityProblem1");
			eq.setStatus("Unsolved");
			
			equipMapper.insert(eq);
			
			return new GlobalResult(200, "故障设备添加成功", null);
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			return new GlobalResult(200, "故障设备添加失败", null);
		}
	}

}
