package com.generator.mapper;

import com.generator.entity.Shebeigsgz;
import java.util.List;

public interface ShebeigsgzMapper {
    int insert(Shebeigsgz record);

    List<Shebeigsgz> selectAll();
}