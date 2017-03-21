package com.xy9860.shop.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.service.CategoryService;

@Service("categoryService")//不需要父类的标签
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	public List<Category> queryJoinAccount(String ctype, int page, int rows) {
		/*return getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type like ?")
				.setParameter(0, "%"+type+"%").list();*///没有分页的写法
		String hql="FROM Category c LEFT JOIN FETCH c.account WHERE c.ctype like ?";
		return getSession().createQuery(hql).setParameter(0, "%"+ctype+"%").setFirstResult((page-1)*rows).setMaxResults(rows).list();
		//显示分页
		//加入FETCH 让他抓取后 将结果集 放进 Account
		//return getSession().createQuery("from Category").list();
	}

	public Long getCount(String ctype) {
		String hql="SELECT count(c) FROM Category c WHERE c.ctype like ?";
		return (Long)getSession().createQuery(hql).setParameter(0, "%"+ctype+"%").uniqueResult();
	}

	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql="DELETE FROM Category WHERE id IN ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
	}

	public List<Category> queryByChot(boolean chot) {
		String hql="FROM Category c  WHERE c.chot = ?";
		return getSession().createQuery(hql)
				.setParameter(0, chot)
				.setFirstResult(0)
				.setMaxResults(3)
				.list();
	}
	
	
	
/*	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Category category) {
		// TODO Auto-generated method stub
		getSession().save(category);
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		getSession().update(category);
	}

	@SuppressWarnings("deprecation")
	public void delete(int id) {
		// TODO Auto-generated method stub
		Object object=getSession().get(Category.class, id);
		if (object!=null) {
			getSession().delete(object);
		}
		String hql="DELETE　category　WHERE id=:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
	}

	public Category get(int id) {
		// TODO Auto-generated method stub
		return (Category)getSession().get(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Category> query() {
		// TODO Auto-generated method stub
		String hql="FROM category";
		return getSession().createQuery(hql).list();
	}*/

}
