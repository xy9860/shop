package com.xy9860.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.model.Sorder;
import com.xy9860.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService {

	public Sorder getByPid(int pid) {
		Sorder sorder=new Sorder();
		Product product=getSession().get(Product.class, pid);
		sorder.setProduct(product);
		sorder.setSname(product.getPname());
		sorder.setSnumber(1);
		sorder.setSprice(product.getPrice());
		return sorder;
	}

	public Forder updateSorder(int pid, int snumber, Forder forder) {
		// TODO Auto-generated method stub
		for (Sorder temp : forder.getSorders()) {
			if (temp.getProduct().getPid().equals(pid)) {
				temp.setSnumber(snumber);
			}
		}
		return forder;
	}

	public List<Object> querySale(int number) {
		String hql="SELECT s.sname , sum(s.snumber)FROM Sorder s LEFT JOIN s.product GROUP BY s.product.pid";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}


}
