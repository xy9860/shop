package com.xy9860.shop.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.service.ForderService;
import com.xy9860.shop.service.SorderService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ForderServiceImplTest {

	@Resource
	private SorderService sorderService;
	@Resource
	private ForderService forderService;
	
	@Test
	public void testAddSorder() {
		Forder forder=new Forder();
		forderService.addSorder(forder, sorderService.getByPid(1));
		forderService.addSorder(forder, sorderService.getByPid(1));
		forderService.addSorder(forder, sorderService.getByPid(1));
		forderService.addSorder(forder, sorderService.getByPid(1));
		forderService.addSorder(forder, sorderService.getByPid(1));
		forderService.addSorder(forder, sorderService.getByPid(1));
		System.out.println(forder.getSorders());
	}

}
