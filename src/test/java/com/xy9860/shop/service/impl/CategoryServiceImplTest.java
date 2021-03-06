package com.xy9860.shop.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Category;
import com.xy9860.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CategoryServiceImplTest {

	@Resource
	private CategoryService categoryService;
	
	@Test
	public void testSave() {
		System.out.println(categoryService);
		categoryService.save(new Category("测试一下",false));
	}

	@Test
	public void testUpdate() {
		categoryService.update(new Category(2, "2222", false));
	}

	@Test
	public void testDelete() {
		categoryService.delete(3);
	}

	@Test
	public void testGet() {	
		System.out.println(categoryService.get(2));
	}

	@Test
	public void testQuery() {
		for (Category temp :categoryService.query()) {
			System.out.println(temp);
		}
	}
	
	@Test
	public void testqueryJoinAccount() {	
		//System.out.println(categoryService.queryJoinAccount(""));
		for (Category category : categoryService.queryJoinAccount("",1,2)) {
			System.out.println(category);
			System.out.println(category.getAccount());
		}
	}
	
	@Test
	public void testqueryByChot() {	
		//System.out.println(categoryService.queryJoinAccount(""));
		for (Category category : categoryService.queryByChot(true)) {
			System.out.println(category);
			//System.out.println(category.getAccount());
		}
	}
	
	@Test
	public void testGetCount(){
		System.out.println(categoryService.getCount(""));
	}
	@Test
	public void testDeleteByIds(){
		categoryService.deleteByIds("5,6,7,8");
	}

}
