package cn.lastwhisper.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.product.mapper.GaselectedmpsnoMapper;
import cn.lastwhisper.product.pojo.Gaselectedmpsno;
import cn.lastwhisper.product.service.GASelectedMPSNoService;
import cn.lastwhisper.productplan.pojo.Mps;
import cn.lastwhisper.productplan.service.MpsService;

@Service
public class GASelectedMPSNoServiceImpl implements GASelectedMPSNoService {
	
	@Autowired
	private GaselectedmpsnoMapper gaselectedmpsnoMapper;
	@Autowired
	private MpsService mpsService;
	
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
	@Transactional(rollbackFor = Exception.class)
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
			return new GlobalResult(200, "工件添加成功", null);
		}catch(Exception e){
			e.getMessage();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//如果updata2()抛了异常,updata()会回滚,不影响事物正常执行
			return new GlobalResult(200, "工件添加失败", null);
		}
	}

}
