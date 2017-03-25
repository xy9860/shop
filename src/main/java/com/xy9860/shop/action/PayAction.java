package com.xy9860.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.SendData;

@Controller
@Scope("prototype")
public class PayAction extends BaseAction<SendData>  {
	
	/*private Map<String, String[]> parameters=null;*/
	
	public String goBank() {
		//1.补全参数  P2 P3 Pd Pa需要从session中获取
		Forder forder=(Forder)session.get("oldForder");
		model.setP2_Order(forder.getFid().toString());
		model.setP3_Amt(forder.getFtotal().toString());
		model.setPa_MP(forder.getUser().getUemail()+forder.getUser().getUphone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储到requet中
		payService.saveDataToRequest(request, model);
		//5.跳转到支付页面
		
		return "pay";
	}

	/*@Override
	public SendData getModel() {
		// TODO Auto-generated method stub
		return super.getModel();
	}

	public void setParameters(Map<String, String[]> parameters) {
		// TODO Auto-generated method stub
		this.parameters=parameters;
	}*/
	
}
