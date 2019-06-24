package com.fly.news.service;


import com.fly.news.dao.NewsDetailDao;
import com.fly.news.dao.NewsTypeDao;
import com.fly.news.entity.NewsDetail;
import com.fly.news.entity.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: <BlogService><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Service
public class NewsDetailService {

    @Autowired
    NewsDetailDao newsDetailDao;

    public NewsDetail saveNewsDetail(NewsDetail newsDetail) {
        return newsDetailDao.save(newsDetail);
    }

    public void deleteNewsDetail(long id) {
        newsDetailDao.delete(id);
    }

    public List<NewsDetail> findListByTypeid(int typeid) {
        return newsDetailDao.findByTypeid(typeid);
    }
}
