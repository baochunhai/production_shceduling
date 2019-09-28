package cn.lastwhisper.productplan.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.lastwhisper.productplan.service.InsertSheetService;


@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
@Service
public class InsertSheetServiceImpl  implements InsertSheetService{
	
	//private static Logger logger = LoggerFactory.getLogger(InsertSheetServiceImpl.class);
}
