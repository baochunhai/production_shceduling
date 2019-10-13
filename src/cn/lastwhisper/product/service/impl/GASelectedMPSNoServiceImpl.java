package cn.lastwhisper.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import Main0622.Class1;
import cn.lastwhisper.core.util.EasyUIDataGridResult;
import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.product.mapper.GamaxendtimeMapper;
import cn.lastwhisper.product.mapper.GascheduleMapper;
import cn.lastwhisper.product.mapper.GaselectedmpsnoMapper;
import cn.lastwhisper.product.pojo.Gamaxendtime;
import cn.lastwhisper.product.pojo.Gaschedule;
import cn.lastwhisper.product.pojo.Gaselectedmpsno;
import cn.lastwhisper.product.service.GASelectedMPSNoService;
import cn.lastwhisper.productplan.mapper.GaparallelMapper;
import cn.lastwhisper.productplan.mapper.MpsMapper;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.MpsService;

@Service
public class GASelectedMPSNoServiceImpl implements GASelectedMPSNoService {
	
	@Autowired
	private GaselectedmpsnoMapper gaselectedmpsnoMapper;
	@Autowired
	private MpsService mpsService;
	@Autowired
	private GascheduleMapper gascheduleMapper;
	@Autowired
	private GaparallelMapper gAParallelMapper;
	@Autowired
	private GamaxendtimeMapper gamaxendtimeMapper;
	@Autowired
	private MpsMapper mpsMapper;
	
	@Override
	public GlobalResult addGA(List<Gaselectedmpsno> mps) {
		try {
			gaselectedmpsnoMapper.deleteGA();
			for (int i = 0; i < mps.size(); i++) {
				gaselectedmpsnoMapper.insert(mps.get(i));
			}
			
			return new GlobalResult(200, "工件添加成功", null);
		}catch(Exception e){
			e.getMessage();
			return new GlobalResult(200, "工件添加失败", null);
		}
	}

	@Override
	public GlobalResult insertGA(List<Gaselectedmpsno> mps) {
		try {
			for (int i = 0; i < mps.size(); i++) {
				gaselectedmpsnoMapper.deleteByPrimaryKey(mps.get(i).getMpsno());
				gaselectedmpsnoMapper.insert(mps.get(i));
				Mps mps2 = new Mps();
				mps2.setMpsno(mps.get(i).getMpsno());
				mps2.setUrgent("Yes");
				//更新mps表中状态为紧急
				mpsService.updatePlane(mps2);
			}
			System.out.println("工件插入成功");
			return new GlobalResult(200, "工件插入成功", null);
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//如果updata2()抛了异常,updata()会回滚,不影响事物正常执行
			return new GlobalResult(200, "工件插入失败", null);
		}
	}

	@Override
	public EasyUIDataGridResult findSchedulinglistByPage(Mps mps, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Mps> list = gaselectedmpsnoMapper.selectSchedulinglistByPage(mps);
		PageInfo<Mps> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public GlobalResult calculate(List<Mps> mps) {
		try {
//			gaselectedmpsnoMapper.deleteGA();
//			gascheduleMapper.deleteAll();//删除gaschedule表所有数据
//			gAParallelMapper.deleteAll();
			
			//delete from GASchedule
			gascheduleMapper.deleteAll();
			//delete from GAParallel
			gAParallelMapper.deleteAll();
			//delete from GAMaxEndTime
			gamaxendtimeMapper.deleteAll();
			
			
			Gaschedule gaschedule = new Gaschedule();
			Mps mps1= new Mps();
			
			String mpsno = "";
			List<Gaselectedmpsno> selectAll = gaselectedmpsnoMapper.selectAll();
			for (int i = 0; i < mps.size(); i++) {
				//1.埋件
				mps1=mps.get(i);
				mpsno = mps.get(i).getMpsno();
				int partno=1;
				gaschedule.setMpsno(mpsno);
				//获取partno的最大值
				Object count = gascheduleMapper.selectPartno();
				
				if(count!=null) {
					partno = (int) count + 1;
					gaschedule.setPartno(partno);
				}else {
					gaschedule.setPartno(partno);
				}
				//把ga表里数据插入计划表
				gascheduleMapper.insertMps(mpsno,6);
				//更新计划表的partno，通过mpsno
				gascheduleMapper.updateByMpsnoo(gaschedule);
				//把工件更新成待加工
				mps1.setType("");
				mps1.setStatus("待加工");
				mpsMapper.updateByPrimaryKey(mps1);
			}
			Calc();
			saveParallel();//获取SaveParallelDao实例
			//2.面板准备
			deleteData();
			for (int i = 0; i < mps.size(); i++) {
				mpsno = mps.get(i).getMpsno();
				calculate(gaschedule, 1, 5, 11, mpsno);
			}
			Calc();
			saveParallel();//获取SaveParallelDao实例
			//3.蜂窝芯准备
			deleteData();
			for (int i = 0; i < mps.size(); i++) {
				mpsno = mps.get(i).getMpsno();
				calculate(gaschedule, 1, 10, 16, mpsno);
			}
			Calc();
			saveParallel();//获取SaveParallelDao实例
			//4.工装准备
			deleteData();
			for (int i = 0; i < mps.size(); i++) {
				mpsno = mps.get(i).getMpsno();
				calculate(gaschedule, 1, 15, 19, mpsno);
			}
			Calc();
			saveParallel();//获取SaveParallelDao实例
			//5.热管准备--铝蒙皮才有这个工序
			deleteData();
			for (int i = 0; i < mps.size(); i++) {
				if(!"铝蒙皮".equals(mps.get(i).getType())) {
					continue;
				}
				mpsno = mps.get(i).getMpsno();
				calculate(gaschedule, 1, 18, 22, mpsno);
			}
			Calc();
			saveParallel();//获取SaveParallelDao实例
			//6.其他工序
			deleteData();
			for (int i = 0; i < mps.size(); i++) {
				mpsno = mps.get(i).getMpsno();
				int partno = 0;
				//查询
				Object count = gascheduleMapper.selectPartno();
				if(count!=null) {
					partno = (int)count+1;
					gaschedule.setPartno(partno);
				}else {
					gaschedule.setPartno(partno);
				
				if(!"铝蒙皮".equals(mps.get(i).getType())) {
				}
					gascheduleMapper.insertMpsPanel(mpsno,21,9999);
					//补足M1之前工序的数据，因为MATLAB程序中，processno是从1开始以1为差连续递增的
					gascheduleMapper.insertMps(mpsno,22);
					gaschedule.setProcessno("22");
					gascheduleMapper.updateProtime(gaschedule);
				}
				if(!"碳蒙皮".equals(mps.get(i).getType())) {
					gascheduleMapper.insertMpsPanel(mpsno,18,9999);
					//补足M1之前工序的数据，因为MATLAB程序中，processno是从1开始以1为差连续递增的
					gascheduleMapper.insertMps(mpsno,19);
					gaschedule.setProcessno("19");
					gascheduleMapper.updateProtime(gaschedule);
				}
				//更新计划表的partno，通过mpsno
				gascheduleMapper.updateByMpsnoo(gaschedule);
				
			}
			Calc();
			saveParallel();//获取SaveParallelDao实例
			return new GlobalResult(200, "排产成功", null);
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			return new GlobalResult(200, "排产失败", null);
		}
	}

	public void Calc() {
		Class1 testGAClass = null;
		try {
			testGAClass = new Class1();

			testGAClass.Main0622();
			testGAClass.waitForFigures();
			System.out.println("Great!");

		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}

		finally {
			if (testGAClass != null)
				testGAClass.dispose();
		}
	}
	public void saveParallel() {
		List<Gamaxendtime> selectAll = gamaxendtimeMapper.selectAll();
		Double maxendtime = 0d;
		if(selectAll.size()!=0) {
			maxendtime = Double.parseDouble(selectAll.get(0).getMaxendtime())+1;
		}
		int deleteZero = gascheduleMapper.deleteZero();// 删除GASchedule表中加工时间为0的行
		  // 用这个读取出的MaxEndTime+1去更新当前GASchedule中的工序开始时间和工序结束时间，
        // 比如说，GAMaxEndTime中存储的是埋件准备部分的最长完工时间，当前GASchedule中计算出的是面板准备部分各道工序的排产结果，
        // 用这个读取出的MaxEndTime+1去更新当前GASchedule中的工序开始时间和工序结束时间，也就意味着在面板准备部分各道工序的排产结果上，累加上埋件准备部分的最长完工时间+1。
		gascheduleMapper.updateByMpsno(maxendtime);
		// 将更新后的GASchedule中的结果，继续写入GAParallel表，这个GAParallel表不是用来排产的，只是用来输出并行排产的结果，
       	// 靠主键来控制这个复制数据的过程不会覆盖之前已经写入GAParallel表中的排产结果
		gAParallelMapper.insertPall();
		gamaxendtimeMapper.deleteAll();//先清空GAMaxEndTime表，该表应该是始终只有一行一列
		// 以下程序是用于将之前排产结果中的最大完工时间插入数据库中的GAMaxEndTime表，供后续的并行排产程序调用
		gamaxendtimeMapper.insertMaxEndTime();
	}
	
	public void calculate(Gaschedule gaschedule,int partno,int start,int end,String mpsno) {
		gascheduleMapper.deleteAll();//删除gaschedule表所有数据
		gaschedule.setMpsno(mpsno);
		
		//查询
		Object count = gascheduleMapper.selectPartno();
		if(count!=null) {
			partno = (int)count+1;
			gaschedule.setPartno(partno);
		}else {
			gaschedule.setPartno(partno);
		}
		//把ga表里数据插入计划表
		gascheduleMapper.insertMpsPanel(mpsno,start,end);
		//补足前十道工序的数据，因为MATLAB程序中，processno是从1开始以1为差连续递增的
		gascheduleMapper.insertMps(mpsno,start+1);
		
		gaschedule.setProcessno((start+1)+"");
		gascheduleMapper.updateProtime(gaschedule);
		//更新计划表的partno，通过mpsno
		gascheduleMapper.updateByMpsnoo(gaschedule);
	}
	public void deleteData() {
		//delete from GASchedule
		gascheduleMapper.deleteAll();
	}
//加载排序之后的结果
	@Override
	public EasyUIDataGridResult loadProductlistByPage(Mps mps, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List list = gAParallelMapper.selectGASchedlelistByPage(mps);
		PageInfo pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}
	
}
