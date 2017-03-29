package com.xy9860.shop.dao;

import java.math.BigDecimal;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

public interface ForderDao extends BaseDao<Forder> {
	//根据订单编号,更新订单状态
	public void updateStatusByFid(int fid,int tid);
}
