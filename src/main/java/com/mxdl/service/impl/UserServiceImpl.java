package com.mxdl.service.impl;

import com.mxdl.dao.UserDao;
import com.mxdl.model.User;
import com.mxdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2020/3/18<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
    public User save(User user) {
        return userDao.save(user);
    }
}
