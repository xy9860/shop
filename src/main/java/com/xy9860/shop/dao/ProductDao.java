package com.xy9860.shop.dao;

import java.util.List;

import com.xy9860.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	//分页查询
	public List<Product> queryJoinCategory(String pname, int page, int rows);
	//获得所有商品的数量
	public Long getCount(String pname);
	//前端的多行删除
	public void deleteByIds (String ids);
	//根据热点类别查询4的商品
	public List<Product> queryByCid(int cid);
}
