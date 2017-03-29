package com.xy9860.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xy9860.shop.dao.SorderDao;
import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.model.Sorder;

@Repository("sorderDao")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements SorderDao {

	public List<Object> querySale(int number) {
		String hql="SELECT s.sname , sum(s.snumber)FROM Sorder s LEFT JOIN s.product GROUP BY s.product.pid";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}


}
