package com.xy9860.shop.service;

import java.math.BigDecimal;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

public interface ForderService extends BaseService<Forder> {
	public Forder addSorder(Forder forder,Sorder sorder);
	public BigDecimal cluTotal(Forder forder);
	//根据订单编号,更新订单状态
	public void updateStatusByFid(int fid,int tid);
}
