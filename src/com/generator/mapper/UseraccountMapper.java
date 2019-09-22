package com.generator.mapper;

import com.generator.entity.Useraccount;
import java.util.List;

public interface UseraccountMapper {
    int deleteByPrimaryKey(String userno);

    int insert(Useraccount record);

    Useraccount selectByPrimaryKey(String userno);

    List<Useraccount> selectAll();

    int updateByPrimaryKey(Useraccount record);
}