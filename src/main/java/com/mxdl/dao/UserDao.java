package com.mxdl.dao;

import com.mxdl.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2020/3/18<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
