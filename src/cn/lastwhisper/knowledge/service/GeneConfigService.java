package cn.lastwhisper.knowledge.service;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.knowledge.pojo.Genetic;

public interface GeneConfigService {

	GlobalResult configSave(Genetic record);
	Genetic configSelect();
}
