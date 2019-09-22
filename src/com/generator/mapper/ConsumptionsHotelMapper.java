package com.generator.mapper;

import com.generator.entity.ConsumptionsHotel;
import java.util.List;

public interface ConsumptionsHotelMapper {
    int insert(ConsumptionsHotel record);

    List<ConsumptionsHotel> selectAll();
}