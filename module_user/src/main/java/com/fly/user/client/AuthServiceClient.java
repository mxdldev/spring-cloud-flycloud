package com.fly.user.client;

import com.fly.user.client.hystrix.AuthServiceHystrix;
import com.fly.user.entity.JWT;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * Description: <AuthServiceClient><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@FeignClient(value = "uaa-service",fallback = AuthServiceHystrix.class )
public interface AuthServiceClient {

    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);
}



