package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Carbonknowledge;
import java.util.List;

public interface CarbonknowledgeMapper {
    int deleteByPrimaryKey(String processno);

    int insert(Carbonknowledge record);

    Carbonknowledge selectByPrimaryKey(String processno);

    List<Carbonknowledge> selectAll();

    int updateByPrimaryKey(Carbonknowledge record);
}