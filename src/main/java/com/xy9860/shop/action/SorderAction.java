package com.xy9860.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {

	public String addSorder(){
		Forder forder=null;
		if (session.containsKey("forder")) {
			forder=(Forder)session.get("forder");
		}else {
			forder=new Forder();
			session.put("forder", forder);
		}
		forderService.addSorder(forder, sorderService.getByPid(model.getProduct().getPid()));
		forder.setFtotal(forderService.cluTotal(forder));
		return "showCar";
	}
}
