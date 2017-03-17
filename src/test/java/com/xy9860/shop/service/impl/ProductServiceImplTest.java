package com.xy9860.shop.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProductServiceImplTest {

	@Resource
	private ProductService productService;
	
	@Test
	public void testSave() {
		//System.out.println(categoryService);
		//categoryService.save(new Category("测试一下",false));
	}

	@Test
	public void testUpdate() {
		//categoryService.update(new Category(2, "2222", false));
	}

	@Test
	public void testDelete() {
		//categoryService.delete(3);
	}

	@Test
	public void testGet() {	
		System.out.println(productService.get(2));
	}

	@Test
	public void testQuery(){
		for (Product temp : productService.query()) {
			System.out.println(temp);
		}
	}
	
	@Test
	public void testGetCount(){
		System.out.println(productService.getCount(""));
	}
	
	@Test
	public void testqueryJoinAccount() {	
		//System.out.println(categoryService.queryJoinAccount(""));
		for (Product temp : productService.queryJoinCategory("",1,2)) {
			System.out.println(temp);
			System.out.println(temp.getCategory());
		}
	}

}
