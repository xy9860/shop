package com.xy9860.shop.service.impl;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.User;
import com.xy9860.shop.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	public User login(User user) {
		String hql="FROM User u WHERE u.ulogin=? AND u.upass=?";
		return (User)getSession().createQuery(hql)
				.setParameter(0, user.getUlogin())
				.setParameter(1, user.getUpass())
				.uniqueResult();//直接将查出来的对象返回回去
	}

}
