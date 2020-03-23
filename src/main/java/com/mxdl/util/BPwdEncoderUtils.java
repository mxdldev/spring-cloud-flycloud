package com.mxdl.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Description: <BPwdEncoderUtils><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public class BPwdEncoderUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 用BCryptPasswordEncoder
     * @param password
     * @return
     */
    public static String  BCryptPassword(String password){
        return encoder.encode(password);
    }

    /**
     *
     * @param rawPassword 原始密码
     * @param encodedPassword 加密后的密码
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword){
        return encoder.matches(rawPassword,encodedPassword);
    }

}
