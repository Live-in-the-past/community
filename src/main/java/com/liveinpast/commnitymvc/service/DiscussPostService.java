package com.liveinpast.commnitymvc.service;

import com.liveinpast.commnitymvc.dao.DiscussPostMapper;
import com.liveinpast.commnitymvc.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDisPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }


}
