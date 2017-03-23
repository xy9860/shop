package com.xy9860.shop.service;

import com.xy9860.shop.model.User;

public interface UserService extends BaseService<User> {
	public User login(User user);
}
