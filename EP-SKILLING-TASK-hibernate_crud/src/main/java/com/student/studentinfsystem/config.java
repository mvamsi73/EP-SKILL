package com.student.studentinfsystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class config 
{
	StandardServiceRegistry ssr;
	Metadata meta;
	SessionFactory sf;
	Session session;
	Transaction t;
	public config()
	{
		this.ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		this.meta=new MetadataSources(ssr).getMetadataBuilder().build();
		this.sf=meta.getSessionFactoryBuilder().build();
		this.session=sf.openSession();
		this.t=session.beginTransaction();
	}
}
