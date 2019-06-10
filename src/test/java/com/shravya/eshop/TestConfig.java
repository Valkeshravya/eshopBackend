package com.shravya.eshop;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shravya.eshopbackend.daoImpl.CategoryDaoImpl;
import com.shravya.eshopbackend.model.Category;

public class TestConfig 
{
  static AnnotationConfigApplicationContext annotationConfigApplicationContext;
 static	CategoryDaoImpl categoryDaoImpl;
  @BeforeClass
	public static void test1()
	{
		annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.shravya.eshopbackend");
		annotationConfigApplicationContext.refresh();
	     categoryDaoImpl=(CategoryDaoImpl)annotationConfigApplicationContext.getBean("categoryDaoImpl");
        System.out.println("before");
	}

	@Test
	public void test2()
	{
	    Category category=new Category();
        category.setCategoryId(10);
        category.setCategoryName("name");
        category.setCategoryDescription("bye");
		assertEquals("yes", true,categoryDaoImpl.saveCategory(category));
		System.out.println(categoryDaoImpl);
	}
	@Test
	public void test3()
	{
	    Category category=new Category();
        category.setCategoryId(10);
        category.setCategoryName("name");
        category.setCategoryDescription("bye");
		assertEquals("no",false,categoryDaoImpl.saveCategory(category));
		System.out.println(categoryDaoImpl);
	}
}
