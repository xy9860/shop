package com.xy9860.shop.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	public List<Product> queryJoinCategory(String pname, int page, int rows) {
		//两次级联 需要查两次 不然就会报 no session 异常
		//String hql="FROM Product p LEFT JOIN FETCH p.category.account JOIN FETCH p.category WHERE p.pname like ?";//这个多次懒依赖
		String hql="FROM Product p LEFT JOIN FETCH p.category WHERE p.pname like ?";
		return getSession().createQuery(hql).setParameter(0, "%"+pname+"%").setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}

	public Long getCount(String pname) {
		String hql="SELECT count(p) FROM Product p WHERE p.pname like ?";
		return (Long)getSession().createQuery(hql).setParameter(0, "%"+pname+"%").uniqueResult();
	}
	
	
}
