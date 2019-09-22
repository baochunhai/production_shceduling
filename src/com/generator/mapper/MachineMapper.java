package com.generator.mapper;

import com.generator.entity.Machine;
import java.util.List;

public interface MachineMapper {
    int deleteByPrimaryKey(String machineno);

    int insert(Machine record);

    Machine selectByPrimaryKey(String machineno);

    List<Machine> selectAll();

    int updateByPrimaryKey(Machine record);
}