package cn.lastwhisper.knowledge.mapper;

import cn.lastwhisper.knowledge.pojo.Genetic;
import java.util.List;

public interface GeneticMapper {
    int insert(Genetic record);

    List<Genetic> selectAll();
    int delete();
}