package com.xy9860.shop.dao;

import java.util.List;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
