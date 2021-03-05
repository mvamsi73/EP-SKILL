package com.student.studentinfsystem;

import java.util.*;

import org.hibernate.Query;
public class DAO 
{
	public void save(studentpojo s)
	{
		config con=new config();
		con.session.save(s);
		con.t.commit();
		con.session.close();
		con.sf.close();
		System.out.println("Insertion Successful");
	}
	public void update(int col,String value,int key)
	{
		config con=new config();
		int i;
		if(col==1)
		{
			Query q=con.session.createQuery("update studentpojo set address=:add where sregno=:k");
			q.setParameter("add", value);
			q.setParameter("k", key);
			i=q.executeUpdate();
		}
		else
		{
			Query q=con.session.createQuery("update studentpojo set course=:cr where sregno=:k");
			q.setParameter("cr", value);
			q.setParameter("k", key);
			i=q.executeUpdate();
		}
		
		con.t.commit();
		con.session.close();
		con.sf.close();
		if(i>0)
		{
		System.out.println("Updation Successful");
		}
		else
		{
			System.out.println("Updation Failed");
		}
	}
	public void display()
	{
		config con=new config();
		Query q=con.session.createQuery("from studentpojo");
		List<studentpojo> lst=q.list();
		for(studentpojo i:lst)
		{
			System.out.println(i);
		}
		con.session.close();
		con.sf.close();
	}
	public void delete(int key)
	{
		config con=new config();
		Query q=con.session.createQuery("delete from studentpojo where sregno=:k");
		q.setParameter("k", key);
		int i=q.executeUpdate();
		con.session.close();
		con.sf.close();
		if(i>0)
		{
		System.out.println("Deletion Successful");
		}
		else
		{
			System.out.println("Deletion Failed");
		}
	}
}
