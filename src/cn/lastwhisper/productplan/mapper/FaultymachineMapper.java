package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Faultymachine;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaultymachineMapper {
    int deleteByPrimaryKey(@Param("machineno") String machineno, @Param("fstarttime") String fstarttime);

	int insert(Faultymachine record);
	int insertFaultMachine(Faultymachine record);

	Faultymachine selectByPrimaryKey(@Param("machineno") String machineno, @Param("fstarttime") String fstarttime);

	List<Faultymachine> selectAll();

	int updateByPrimaryKey(Faultymachine record);

	List<Faultymachine> selectFault(Faultymachine record);
}