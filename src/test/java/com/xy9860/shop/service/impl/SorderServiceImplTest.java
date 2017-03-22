package com.xy9860.shop.service.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.service.SorderService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SorderServiceImplTest {

	@Resource
	private SorderService sorderService;
	
	@Test
	public void testGetByPid() {
		Integer integer=1;
		System.out.println(integer.hashCode());
		System.out.println(sorderService.getByPid(1));
	}

}
