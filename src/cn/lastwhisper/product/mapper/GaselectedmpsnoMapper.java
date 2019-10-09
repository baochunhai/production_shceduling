package cn.lastwhisper.product.mapper;

import java.util.List;

import cn.lastwhisper.product.pojo.Gaselectedmpsno;

public interface GaselectedmpsnoMapper {
    int deleteByPrimaryKey(String mpsno);

    int insert(Gaselectedmpsno record);

    Gaselectedmpsno selectByPrimaryKey(String mpsno);

    List<Gaselectedmpsno> selectAll();

    int updateByPrimaryKey(Gaselectedmpsno record);
    
    int deleteGA();
}