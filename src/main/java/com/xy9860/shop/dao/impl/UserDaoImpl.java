package com.xy9860.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy9860.shop.dao.UserDao;
import com.xy9860.shop.model.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User login(User user) {
		String hql="FROM User u WHERE u.ulogin=? AND u.upass=?";
		return (User)getSession().createQuery(hql)
				.setParameter(0, user.getUlogin())
				.setParameter(1, user.getUpass())
				.uniqueResult();//直接将查出来的对象返回回去
	}

}
