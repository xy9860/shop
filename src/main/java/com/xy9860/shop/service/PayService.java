package com.xy9860.shop.service;

import java.util.Map;

import com.xy9860.shop.model.BackData;
import com.xy9860.shop.model.SendData;


public interface PayService {
	public Map<String, Object> saveDataToRequest(Map<String, Object> request,
			SendData sendData);
	public boolean checkBackData(BackData backData);
}
