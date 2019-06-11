package com.fly.news.util;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * Description: <><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public class UserUtils {

    private static final String AUTHORIZATION = "authorization";

    /**
     * 获取当前请求的token
     *
     * @return
     */
    public static String getCurrentToken() {
        return HttpUtils.getHeaders(HttpUtils.getHttpServletRequest()).get(AUTHORIZATION);
    }

    /**
     * 获取当前请求的用户Id
     *
     * @return
     */
    public static String getCurrentPrinciple() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 判读当前token用户是否为接口所需的参数username
     *
     * @param username
     * @return
     */
    public static boolean isMyself(String username) {
        return username.equals(getCurrentPrinciple());
    }

    /**
     * 获取当前请求Authentication
     *
     * @return
     */
    public static Authentication getCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前请求的权限信息
     *
     * @return
     */
    public static List<SimpleGrantedAuthority> getCurrentAuthorities() {
        return (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    /**
     * @param role
     * @return
     */
    public static boolean hasRole(String role) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        boolean hasRole = false;
        List<SimpleGrantedAuthority> list = getCurrentAuthorities();
        for (SimpleGrantedAuthority s : list) {
            if (role.equals(s.getAuthority())) {
                hasRole = true;
                break;
            }
        }
        return hasRole;
    }

}
