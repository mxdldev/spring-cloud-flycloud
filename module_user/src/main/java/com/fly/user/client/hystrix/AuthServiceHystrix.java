package com.fly.user.client.hystrix;


import com.fly.user.client.AuthServiceClient;
import com.fly.user.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * Description: <AuthServiceHystrix><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        System.out.println("--------opps getToken hystrix---------");
        return null;
    }
}
