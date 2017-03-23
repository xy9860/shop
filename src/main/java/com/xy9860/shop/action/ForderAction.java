package com.xy9860.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Status;
import com.xy9860.shop.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	//实现订单项和子订单的级联入库
	public String save() {
		//把session中的购物项,交给model对象
		//Forder forder=(Forder)session.get("forder");
		//model.setSorders(forder.getSorders());
		//级联入库 需要 XML中配置  需要sorder关联forder 在forderService.save中添加
		//forderService.save(model);//这样存储的是model而不是 session中的forder
		User user=(User)session.get("user");
		model.setUser(user);
		model.setStatus(new Status(1));
		forderService.save(model);
		//此时购物车已经入库,购物车应该清空
		session.put("oldForder", session.get("forder"));
		session.put("forder", new Forder());
		return "bank";
	}

	@Override
	public Forder getModel() {
		// TODO Auto-generated method stub
		model=(Forder)session.get("forder");
		return  model;//这里重写getmodel 让ognl的顶层直接就是session中的forder
	}
}
