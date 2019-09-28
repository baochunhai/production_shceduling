package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Machine;
import java.util.List;

public interface MachineMapper {
    int deleteByPrimaryKey(String machineno);

    int insert(Machine record);

    Machine selectByPrimaryKey(String machineno);

    List<Machine> selectAll();

    int updateByPrimaryKey(Machine record);
    
    /**
     * 查询故障设备
     * @param machine
     * @return
     */
    public List<Machine> selectMachinelistByPage(Machine machine);
}