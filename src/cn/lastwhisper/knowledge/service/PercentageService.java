package cn.lastwhisper.knowledge.service;

import java.util.List;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Machine;

public interface PercentageService {

	List queryPercentage();
	GlobalResult percentageupdate(Machine machine);
}
