package com.xy9860.shop.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

/**
 * //utf8.sms.webchinese.cn/?Uid=zty2338&Key=b35c7ebd410256ee13ec&smsMob=17713547583&smsText=你好,你的订单2341352653425已经支付
 * 实现短信的发送功能
 * */
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	public int sendMessage(String phone,String fid) {
		//1.打开浏览器
		HttpClient httpClient=new HttpClient();
		//2.创建请求的方式,get/Post
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
		//3.设置请求的参数信息
		post.setParameter("Uid", "zty2338");
		post.setParameter("Key", "b35c7ebd410256ee13ec");
		post.setParameter("smsMob", phone);
		post.setParameter("smsText", "你好,你的订单"+fid+"已经支付");
		//4.在头文件中设置转码
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		//5.提交请求
		int code=0;//状态吗
		String result=null;
		try {
			code=httpClient.executeMethod(post);
			result=post.getResponseBodyAsString();
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			post.releaseConnection();//释放连接
		}
		//获取服务器端返回的数据信息
/*		System.out.println("http返回的状态码"+code);*/
		System.out.println("http返回的发送数量"+result);
		return code;
	}
}
