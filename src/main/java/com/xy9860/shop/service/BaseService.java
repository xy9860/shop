package com.xy9860.shop.service;

import java.util.List;

public interface BaseService<T> {//这是抽取出来的Service 模板
	public void save(T t);
	public void update(T t);
	public void delete(int id);
	public T get(int id);
	public List<T> query();
}
