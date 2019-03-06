package com.aaa.dao;

import com.aaa.entity.Circle;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircleDao {
    @Select("select * from circle  limit #{param1},#{param2}")
    public List<Circle> query(Integer offict,Integer pagesize);
    @Select("select * from circle")
    public List<Circle> queryAll();
    /*查询出最近的10条帖子*/
    @Select("SELECT *, ABS(NOW() - time)  AS diffTime FROM circle ORDER BY time ASC LIMIT 0, 10")
    public List<Circle> diffTime();
}
