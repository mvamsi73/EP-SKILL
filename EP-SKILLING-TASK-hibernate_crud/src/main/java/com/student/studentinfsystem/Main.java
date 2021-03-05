package com.student.studentinfsystem;
import java.util.*;
public class Main {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		DAO d=new DAO();
		while(true)
		{
			System.out.println("Select an option\n1.Insert\n2.Update\n3.Read\n4.Delete\n5.Exit");
			int ch=s.nextInt();
			switch(ch)
			{
			case 1:
				studentpojo sp=new studentpojo();
				System.out.println("Enter Student ID:");
				sp.setSregno(s.nextInt());
				System.out.println("Enter Student Name:");
				sp.setName(s.next());
				System.out.println("Enter Student DOB:");
				sp.setDob(s.next());
				System.out.println("Enter Student Email:");
				sp.setEmail(s.next());
				System.out.println("Enter Student Address:");
				sp.setAddress(s.next());
				System.out.println("Enter Student Course:");
				sp.setCourse(s.next());
				d.save(sp);
				break;
			case 2:
				System.out.println("Enter ID of the student you want to update:");
				int key=s.nextInt();
				System.out.println("Enter Column you want to update:\n1.Address\n2.Course");
				int col=s.nextInt();
				System.out.println("Enter new Value in the Column:");
				String value=s.next();
				d.update(col, value, key);
				break;
			case 3:
				d.display();
				break;
			case 4:
				System.out.println("Enter the id number to delete:");
				int k=s.nextInt();
				d.delete(k);
				break;
			case 5:
				System.exit(0);
			}				
		}

	}

}
