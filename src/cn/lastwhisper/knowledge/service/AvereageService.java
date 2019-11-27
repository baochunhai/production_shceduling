package cn.lastwhisper.knowledge.service;

import java.util.List;

import cn.lastwhisper.core.util.GlobalResult;
import cn.lastwhisper.productplan.pojo.Carbonknowledge;



public interface AvereageService {

	List<String> cavelistByPage(Carbonknowledge type);
	List<String> aavelistByPage(Carbonknowledge type);
	GlobalResult update(Carbonknowledge type);
}
