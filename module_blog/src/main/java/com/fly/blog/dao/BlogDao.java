package com.fly.blog.dao;

import com.fly.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description: <BlogDao><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface BlogDao extends JpaRepository<Blog, Long> {

    List<Blog> findByUsername(String username);

}
