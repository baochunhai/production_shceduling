package cn.lastwhisper.product.mapper;

import cn.lastwhisper.product.pojo.Gamaxendtime;
import java.util.List;

public interface GamaxendtimeMapper {
    int deleteByPrimaryKey(String maxendtime);

    int insert(Gamaxendtime record);

    List<Gamaxendtime> selectAll();
    
    int deleteAll();
    
    int insertMaxEndTime();
    
}