package com.shravya.eshopbackend;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context=new ClassPathXmlApplicationContext("Dbconfig.xml");
SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
System.out.println("Hello"+sessionFactory);
	}

}
