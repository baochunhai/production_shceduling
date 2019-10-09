package cn.lastwhisper.product.service;

import java.util.List;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.product.pojo.Gaselectedmpsno;

public interface GASelectedMPSNoService {

	public GlobalResult addGA(List<Gaselectedmpsno> mps);
	
	public GlobalResult insertGA(List<Gaselectedmpsno> mps);
}
