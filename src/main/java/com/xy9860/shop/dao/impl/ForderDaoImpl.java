package com.xy9860.shop.dao.impl;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.xy9860.shop.dao.ForderDao;
import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao {
	public void updateStatusByFid(int fid, int tid) {
		// TODO Auto-generated method stub
		String hql="UPDATE Forder f SET f.status.tid=? WHERE f.fid=?";
		getSession().createQuery(hql)
		.setParameter(0, tid).setParameter(1, fid)
		.executeUpdate();
	}

}
