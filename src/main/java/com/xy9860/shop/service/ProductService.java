package com.xy9860.shop.service;

import java.util.List;

import com.xy9860.shop.model.Product;

public interface ProductService extends BaseService<Product>{
	public List<Product> queryJoinCategory(String pname, int page, int rows);
	public Long getCount(String pname);
	public void deleteByIds (String ids);
}
