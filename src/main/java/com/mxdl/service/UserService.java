package com.mxdl.service;

import com.mxdl.model.User;

import java.util.List;
/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2020/3/18<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
