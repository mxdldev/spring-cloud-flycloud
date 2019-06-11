package com.fly.news.client.hystrix;

import com.fly.common.dto.RespDTO;
import com.fly.news.client.UserServiceClient;
import com.fly.news.entity.User;
import org.springframework.stereotype.Component;

/**
 * Description: <UserServiceHystrix><br>
 * Author:    门心叼龙<br>
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
