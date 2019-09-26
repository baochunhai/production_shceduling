package cn.lastwhisper.productplan.mapper;

import cn.lastwhisper.productplan.pojo.Aluminumknowledge;
import java.util.List;

public interface AluminumknowledgeMapper {
    int deleteByPrimaryKey(String processno);

    int insert(Aluminumknowledge record);

    Aluminumknowledge selectByPrimaryKey(String processno);

    List<Aluminumknowledge> selectAll();

    int updateByPrimaryKey(Aluminumknowledge record);
}