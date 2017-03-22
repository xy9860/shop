package com.xy9860.shop.service.impl;

import org.springframework.stereotype.Service;

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

}
