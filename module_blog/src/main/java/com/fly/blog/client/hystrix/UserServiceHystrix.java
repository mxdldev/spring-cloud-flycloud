package com.fly.blog.client.hystrix;

import com.fly.blog.client.UserServiceClient;
import com.fly.blog.entity.User;
import com.fly.common.dto.RespDTO;
import org.springframework.stereotype.Component;

/**
 * Description: <UserServiceHystrix><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}
