package com.xy9860.shop.service;

import java.util.List;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	public Sorder getByPid(int pid);
	public Forder updateSorder(int pid,int snumber ,Forder forder);
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
