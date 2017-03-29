package com.xy9860.shop.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.xy9860.shop.dao.ProductDao;
import com.xy9860.shop.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
	public List<Product> queryJoinCategory(String pname, int page, int rows) {
		//两次级联 需要查两次 不然就会报 no session 异常
		//String hql="FROM Product p LEFT JOIN FETCH p.category.account JOIN FETCH p.category WHERE p.pname like ?";//这个多次懒依赖
		String hql="FROM Product p LEFT JOIN FETCH  p.category LEFT JOIN FETCH p.category.account WHERE p.pname like ?";
		return getSession().createQuery(hql).setParameter(0, "%"+pname+"%").setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}

	public Long getCount(String pname) {
		String hql="SELECT count(p) FROM Product p WHERE p.pname like ?";
		return (Long)getSession().createQuery(hql).setParameter(0, "%"+pname+"%").uniqueResult();
	}
	
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql="DELETE FROM Product WHERE id IN ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
	}
	
	public List<Product> queryByCid(int cid) {
		String hql="FROM Product p INNER JOIN FETCH p.category WHERE p.pcommend=true AND p.popen=true AND p.category.cid=? ORDER BY p.pdate DESC";
		return getSession().createQuery(hql)
				.setParameter(0, cid)
				.setFirstResult(0).setMaxResults(4)
				.list();
	}
/*
	public List<Category> queryJoinAccount(String ctype, int page, int rows) {
		return getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type like ?")
				.setParameter(0, "%"+type+"%").list();//没有分页的写法
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
	}*/


	
}
