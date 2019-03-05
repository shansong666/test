package com.aaa.dao;

import com.aaa.entity.Clable;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClableDao {
    @Select("select * from clable limit #{param1},#{param2}")
    public List<Clable> query(Integer offict,Integer pagesize);
    @Select("select * from clable")
    public List<Clable> queryAll();
}
