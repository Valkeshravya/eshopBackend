package com.shravya.eshopbackend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shravya.eshopbackend.model.Category;

public class TestCon 
{
	ApplicationContext context=new ClassPathXmlApplicationContext("Dbconfig.xml");
	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");

	void testData()
	{
		System.out.println("Hello"+sessionFactory);
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("sam");
        category.setCategoryDescription("bbc");
        Session session=sessionFactory.openSession();
        session.save(category);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
	}
}
