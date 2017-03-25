package com.xy9860.shop.service.impl;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.model.Sorder;
import com.xy9860.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	public Forder addSorder(Forder forder, Sorder sorder) {
		Iterator<Sorder> it=forder.getSorders().iterator();
		while (it.hasNext()) {
			Sorder temp=it.next();
			if (temp.hashCode()==sorder.hashCode()) {// 如果购物车中存在同样的商品
				sorder.setSnumber(temp.getSnumber()+1);
				forder.getSorders().remove(temp);
				break;
			}
		}
		sorder.setForder(forder);//建立购物项和购物车的关联,此时forder为空,入库时先入forder再入购物车  就会有fid
		forder.getSorders().add(sorder);
		/*Iterator<Sorder> it2=forder.getSorders().iterator();
		while (it2.hasNext()) {
			Sorder temp=it2.next();
			if (forder.getFtotal()==null) {
				forder.setFtotal(new Double(0));
			}
			System.out.println(forder.getFtotal());
			System.out.println(temp.getSprice());
			System.out.println(temp.getSprice()*temp.getSnumber());
			forder.setFtotal(forder.getFtotal()+temp.getSprice());
		}*/
		return forder;
	}
	
	public double cluTotal(Forder forder){
		double total=0;
		for (Sorder sorder : forder.getSorders()) {
			total+=sorder.getSprice()*sorder.getSnumber();
		}
		return total;
	}

	public void updateStatusByFid(int fid, int tid) {
		// TODO Auto-generated method stub
		String hql="UPDATE Forder f SET f.status.tid=? WHERE f.fid=?";
		getSession().createQuery(hql)
		.setParameter(0, tid).setParameter(1, fid)
		.executeUpdate();
	}



}
