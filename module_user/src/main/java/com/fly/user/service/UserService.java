package com.fly.user.service;

import com.fly.common.dto.RespDTO;
import com.fly.common.exception.CommonException;
import com.fly.common.exception.ErrorCode;
import com.fly.user.dao.UserDao;
import com.fly.user.dto.LoginDTO;
import com.fly.user.entity.JWT;
import com.fly.user.entity.User;
import com.fly.user.util.BPwdEncoderUtils;
import com.fly.user.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: <UserService><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthServiceClient authServiceClient;

    public User createUser(User user){
      return  userDao.save(user);
    }

    public User getUserInfo(String username){
        return userDao.findByUsername(username);
    }
    public RespDTO login(String username , String password){
       User user= userDao.findByUsername(username);
       if(null==user){
           throw new CommonException(ErrorCode.USER_NOT_FOUND);
       }
       if(!BPwdEncoderUtils.matches(password,user.getPassword())){
           throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
       }

        JWT jwt = authServiceClient.getToken("Basic dWFhLXNlcnZpY2U6MTIzNDU2", "password", username, password);
        // 获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());
        return RespDTO.onSuc(loginDTO);
    }
}
