package com.liveinpast.commnitymvc.dao;

import com.liveinpast.commnitymvc.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //when dynamically inputting data and only one parameter, use in <if>,  should add "@Param" annotation
    int selectDiscussPostRows(@Param("userId") int userId);




}
