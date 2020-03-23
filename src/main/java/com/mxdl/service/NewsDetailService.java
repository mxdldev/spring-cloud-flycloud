package com.mxdl.service;


import com.mxdl.dao.NewsDetailDao;
import com.mxdl.model.NewsDetail;
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

    public NewsDetail findNewsDetailById(long id) {
        return newsDetailDao.findOne(id);
    }

    public void deleteNewsDetail(long id) {
        newsDetailDao.delete(id);
    }

    public List<NewsDetail> findListByTypeid(int typeid) {
        return newsDetailDao.findByTypeid(typeid);
    }
}
