package com.mxdl.service;


import com.mxdl.dao.NewsTypeDao;
import com.mxdl.model.NewsType;
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
public class NewsTypeService {

    @Autowired
    NewsTypeDao newsTypeDao;

    public NewsType saveNewsType(NewsType newstype) {
        return newsTypeDao.save(newstype);
    }

    public void deleteBlog(long id) {
         newsTypeDao.delete(id);
    }

    public List<NewsType> findListNewsType(){
        return  newsTypeDao.findAll();
    }

}
