package com.fly.blog.service;


import com.fly.blog.client.UserServiceClient;
import com.fly.blog.dao.BlogDao;
import com.fly.blog.dto.BlogDetailDTO;
import com.fly.blog.entity.Blog;
import com.fly.blog.entity.User;
import com.fly.blog.util.UserUtils;
import com.fly.common.dto.RespDTO;
import com.fly.common.exception.CommonException;
import com.fly.common.exception.ErrorCode;
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
public class BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    UserServiceClient userServiceClient;

    public Blog postBlog(Blog blog) {
        return blogDao.save(blog);
    }

    public List<Blog> findBlogs(String username) {
        return blogDao.findByUsername(username);
    }


    public BlogDetailDTO findBlogDetail(Long id) {
        Blog blog = blogDao.findOne(id);
        if (null == blog) {
            throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
        }
        RespDTO<User> respDTO = userServiceClient.getUser(UserUtils.getCurrentToken(), blog.getUsername());
        if (respDTO==null) {
            throw new CommonException(ErrorCode.RPC_ERROR);
        }
        BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
        blogDetailDTO.setBlog(blog);
        blogDetailDTO.setUser(respDTO.data);
        return blogDetailDTO;
    }

}
