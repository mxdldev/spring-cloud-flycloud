package com.fly.uaa.dao;


import com.fly.uaa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: <UserDao><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
