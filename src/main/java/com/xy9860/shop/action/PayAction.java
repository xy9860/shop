package com.xy9860.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.BackData;
import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.SendData;
/**
 * 这个类示范了一个类操作两个实体的功能
 * */
@Controller
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware {
	
	private Map<String, String[]> parameters=null;
	
	public String goBank() {
		SendData sendData=(SendData)model;
		//1.补全参数  P2 P3 Pd Pa需要从session中获取
		Forder forder=(Forder)session.get("oldForder");
		sendData.setP2_Order(forder.getFid().toString());
		sendData.setP3_Amt(forder.getFtotal().toString());
		sendData.setPa_MP(forder.getUser().getUemail()+","+forder.getUser().getUphone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储到requet中
		payService.saveDataToRequest(request, sendData);
		//5.跳转到支付页面
		
		return "pay";
	}
	
	public String backBank() {
		BackData backData=(BackData)model;
		if (payService.checkBackData(backData)) {
			System.out.println("----------ok---------");
		}else{
			System.out.println("----------fail---------");
		}
		return "";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if (parameters.get("pd_FrpId")!=null) {//判断生成的model 时候有pd_FrpId(银行选择这个参数)
			model=new SendData();System.out.println("SendData");
		} else {
			model=new BackData();System.out.println("BackData");
		}
		return model;
	}

	public void setParameters(Map<String, String[]> parameters) {
		// TODO Auto-generated method stub
		this.parameters=parameters;
	}
	
}
