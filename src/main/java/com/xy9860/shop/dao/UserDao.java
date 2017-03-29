package com.xy9860.shop.dao;

import com.xy9860.shop.model.User;

public interface UserDao extends BaseDao<User> {
	public User login(User user);
}
