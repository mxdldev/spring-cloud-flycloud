package com.mxdl.controller;

import com.mxdl.model.User;
import com.mxdl.service.UserService;
import com.mxdl.util.BPwdEncoderUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        user.setPassword(BPwdEncoderUtils.BCryptPassword(user.getPassword()));
        return userService.save(user);
    }

//    @ApiOperation(value = "删除用户", notes = "删除用户")
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable(value = "id") Long id){
//        userService.delete(id);
//        return "success";
//    }

}
