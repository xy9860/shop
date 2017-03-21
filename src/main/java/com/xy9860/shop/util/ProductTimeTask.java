package com.xy9860.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.service.CategoryService;
import com.xy9860.shop.service.ProductService;
/**
 * 用于后台的定时更新
 * */
@Component("productTimeTask")
public class ProductTimeTask extends TimerTask {
	@Resource
	private ProductService productService=null;
	@Resource
	private CategoryService categoryService=null;
	
	private ServletContext application =null;//内置对象
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	@Override
	public void run() {
		List<List<Product>> bigList=new ArrayList<List<Product>>();//存放所有商品的大集合
		//System.out.println(productService);
		for (Category category : categoryService.queryByChot(true)) {
			bigList.add(productService.queryByCid(category.getCid()));
		}
		application.setAttribute("bigList", bigList);//放到Appliction中便于查询
	}

}
