package com.xy9860.shop.service.impl;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.User;
import com.xy9860.shop.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	public User login(User user) {
		return userDao.login(user);
	}

}
