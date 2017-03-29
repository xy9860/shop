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
		Product product=productDao.get(pid);
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
		return sorderDao.querySale(number);
	}


}
