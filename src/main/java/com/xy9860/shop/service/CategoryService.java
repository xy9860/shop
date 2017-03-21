package com.xy9860.shop.service;

import java.util.List;

import com.xy9860.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	public List<Category> queryJoinAccount(String ctype, int page, int rows);
	public Long getCount(String ctype);
	//根据ID删除多条记录
	public void deleteByIds (String ids);
	//查询热点类别
	public List<Category> queryByChot(boolean chot);
}
