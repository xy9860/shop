package com.xy9860.shop.service.impl;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;
import com.xy9860.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	public Forder addSorder(Forder forder, Sorder sorder) {
		Iterator<Sorder> it=forder.getSorders().iterator();
		if (forder.getFtotal()==null) {
			forder.setFtotal(new Double(0));
		}
		forder.setFtotal(forder.getFtotal()+sorder.getSprice());
		while (it.hasNext()) {
			Sorder temp=it.next();
			if (temp.hashCode()==sorder.hashCode()) {
				sorder.setSnumber(temp.getSnumber()+1);
				forder.getSorders().remove(temp);
				break;
			}
		}
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

}
