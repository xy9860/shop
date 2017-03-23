package com.xy9860.shop.service;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

public interface ForderService extends BaseService<Forder> {
	public Forder addSorder(Forder forder,Sorder sorder);
	public double cluTotal(Forder forder);
}
