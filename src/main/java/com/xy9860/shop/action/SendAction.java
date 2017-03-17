package com.xy9860.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 
 * 这个Action 用来完成web-inf转发的功能,不处理任何业务逻辑
 * */
@Controller
public class SendAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "send";
	}
	
	
}
