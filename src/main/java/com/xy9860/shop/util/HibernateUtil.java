package com.xy9860.shop.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	static{
		bulidFactory();
	}
	private HibernateUtil(){}
	
	public static Session getSession(){
		if (sessionFactory==null) {
			bulidFactory();
		}
		return sessionFactory.openSession();
	}
	private static void bulidFactory(){
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
}
