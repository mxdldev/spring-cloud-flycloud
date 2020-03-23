package com.mxdl.dao;


import com.mxdl.model.NewsDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description: <NewsDetailDao><br>
 * Author:    mxdl<br>
 * Date:      2019/6/11<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface NewsDetailDao extends JpaRepository<NewsDetail, Long> {
    List<NewsDetail> findByTypeid(int typeid);
}