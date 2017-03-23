package com.xy9860.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.User;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	public String login() {
		model=userService.login(model);
		if (model==null) {
			session.put("error", "登陆失败");
			return "ulogin";
		}else {
			//先存储到session根据情况访问相应的页面 
			session.put("user", model);
			if (session.get("goURL")==null) {
				return "index";
			}else {
				return "goURL";
			}
		}
	}
}
