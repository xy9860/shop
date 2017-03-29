package com.xy9860.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.xy9860.shop.dao.AccountDao;
import com.xy9860.shop.dao.BaseDao;
import com.xy9860.shop.dao.CategoryDao;
import com.xy9860.shop.dao.ForderDao;
import com.xy9860.shop.dao.ProductDao;
import com.xy9860.shop.dao.SorderDao;
import com.xy9860.shop.dao.UserDao;
import com.xy9860.shop.service.BaseService;

@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@SuppressWarnings("rawtypes")
	public BaseServiceImpl() {//构造方法获得Class信息 最先执行
		//super();
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();//获得当前调用这个构造方法的父类信息(包括泛型)
		clazz=(Class)type.getActualTypeArguments()[0];//获取泛型类的信息 0表示第一个参数
	}

	@SuppressWarnings("rawtypes")
	private Class clazz;//假设这个里面有关于类的所有信息
	
/*	@Resource  //默认名字和id一样
	protected SessionFactory sessionFactory;*///Dao抽取时从Service层抽走
	
/*	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*///使用注解后 不需要setter方法
	
	/*protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}*/
	@PostConstruct//第三步执行
	public void init(){
		//在这里对baseDao赋值  根据clazz把不同的dao对象赋值过去
		String clazzName=clazz.getSimpleName();//泛型类的名称
		String clazzDao=clazzName.substring(0,1).toLowerCase()+clazzName.substring(1)+"Dao";//拼接class对应的Dao
		try {
			Field clazzFiled=this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseFiled=this.getClass().getSuperclass().getDeclaredField("beseDao");
			baseFiled.set(this, clazzFiled.get(this));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
/*	@PreDestroy//第四步执行
	public void destory(){
		
	}*/
	
	protected BaseDao beseDao;//如果当前的 T 是account 则是accountDao
	@Resource//第二部执行
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;

	public void save(T t) {
		// TODO Auto-generated method stub
		beseDao.save(t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		beseDao.update(t);
	}

	public void delete(int id) {
		beseDao.delete(id);
	}

	@SuppressWarnings("unchecked")
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T)beseDao.get(id);
	}

	@SuppressWarnings("unchecked")
	public List<T> query() {
		// TODO Auto-generated method stub
		return beseDao.query();
	}

}
