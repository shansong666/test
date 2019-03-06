package com.aaa.dao;

import com.aaa.entity.Review;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {
    @Select("select * from ")
    public List<Review> queryByComposeid(Integer composeid);
}
