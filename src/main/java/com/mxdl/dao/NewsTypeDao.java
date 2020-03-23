package com.mxdl.dao;


import com.mxdl.model.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: <NewsTypeDao><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface NewsTypeDao extends JpaRepository<NewsType, Long> {
}
