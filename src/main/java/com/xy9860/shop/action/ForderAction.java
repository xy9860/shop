package com.xy9860.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Forder;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	//实现订单项和子订单的级联入库
	public String save() {
		//把session中的购物项,交给model对象
		Forder forder=(Forder)session.get("forder");
		model.setSorders(forder.getSorders());
		//级联入库 需要 XML中配置
		forderService.save(model);
		return "bank";
	}
}
