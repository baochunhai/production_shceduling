package cn.lastwhisper.modular.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.lastwhisper.modular.service.InsertSheetService;

@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
@Service
public class InsertSheetServiceImpl  implements InsertSheetService{
	
	private static Logger logger = LoggerFactory.getLogger(InsertSheetServiceImpl.class);
}
