package com.xy9860.shop.service;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

public interface ForderService extends BaseService<Forder> {
	public Forder addSorder(Forder forder,Sorder sorder);
	public double cluTotal(Forder forder);
	//根据订单编号,更新订单状态
	public void updateStatusByFid(int fid,int tid);
}
