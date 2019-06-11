package com.fly.news.dao;


import com.fly.news.entity.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: <NewsTypeDao><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface NewsTypeDao extends JpaRepository<NewsType, Long> {
}
