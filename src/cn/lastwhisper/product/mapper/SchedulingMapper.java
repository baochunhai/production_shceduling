package cn.lastwhisper.product.mapper;

import cn.lastwhisper.product.pojo.Scheduling;
import java.util.List;

public interface SchedulingMapper {
    int insert(Scheduling record);

    List<Scheduling> selectAll();
    int showScheduling();
}