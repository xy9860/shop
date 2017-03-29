package com.xy9860.shop.action;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
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
	//根据商品编号 和数量 更新
	public String updateSorder(){
		Forder forder=(Forder)session.get("forder");
		forder=sorderService.updateSorder(model.getProduct().getPid(), model.getSnumber(), forder);
		forder.setFtotal(forderService.cluTotal(forder));
		//返回行的总价格
		inputStream=new ByteArrayInputStream(forder.getFtotal().toString().getBytes());
		return "stream";
	}
	
	public String querySale(){
		List<Object> jsonList=sorderService.querySale(model.getSnumber());
		ActionContext.getContext().getValueStack().push(jsonList);//扔到栈顶,在json转换的时候会自动读取栈顶的数据
		return "jsonList";
	}
	
}
