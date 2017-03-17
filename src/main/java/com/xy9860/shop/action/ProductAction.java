package com.xy9860.shop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory(){
		pageMap =new HashMap<String, Object>();//用来存储分页的数据
		List<Product> Products= productService.queryJoinCategory(model.getPname(), page, rows);//根据关键字和分页参数查询相应的数据
		Long total=productService.getCount(model.getPname());//根据关键字和分页参数查询相应的数据的条数
		pageMap.put("total", total);
		pageMap.put("rows", Products);
		return "jsonMap";
	}
	
}
