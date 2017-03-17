package com.xy9860.shop.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Account;
import com.xy9860.shop.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AccountServiceImplTest {

	@Resource
	private AccountService accountService;
	
	@Test
	public void testSave() {
		accountService.save(new Account("user1","客服2","user1"));
	}

	@Test
	public void testUpdate() {
		accountService.update(new Account(3, "user1","客服2Test","user1"));
	}

	@Test
	public void testDelete() {
		accountService.delete(3);
	}

	@Test
	public void testGet() {	
		System.out.println(accountService.get(1));
	}

	@Test
	public void testQuery() {
		for (Account temp :accountService.query()) {
			System.out.println(temp);
		}
	}

}
