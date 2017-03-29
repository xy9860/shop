package com.xy9860.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.xy9860.shop.dao.BaseDao;

@Service("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {//构造方法获得Class信息
		//super();
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();//获得当前调用这个构造方法的父类信息(包括泛型)
		clazz=(Class)type.getActualTypeArguments()[0];//获取泛型类的信息 0表示第一个参数
	}

	@SuppressWarnings("rawtypes")
	private Class clazz;//假设这个里面有关于类的所有信息
	
	@Resource  //默认名字和id一样
	protected SessionFactory sessionFactory;
	
/*	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*///使用注解后 不需要setter方法
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}


	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

	@SuppressWarnings("unchecked")
	public void delete(int id) {
		Object object=getSession().get(clazz, id);
		if (object!=null) {
			getSession().delete(object);
		}	}

	@SuppressWarnings("unchecked")
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T)getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> query() {
		// TODO Auto-generated method stub
		String hql="FROM "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
