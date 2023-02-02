package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Purchase;
import com.simplilearn.entity.Shoes;
import com.simplilearn.entity.User;


public class HibernateUtil {
	
	public static SessionFactory sessionfactory = null ;
	
	public static SessionFactory buildSessionFactory() {
		if(sessionfactory == null ) {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Shoes.class).addAnnotatedClass(Purchase.class) ;
			sessionfactory = configuration.buildSessionFactory() ;
		}
		
		return sessionfactory ;
	}
}
