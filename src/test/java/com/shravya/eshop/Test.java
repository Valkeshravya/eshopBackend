package com.shravya.eshop;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Test 
{
@BeforeClass
public static void test1()
{
	System.out.println("from before class");
}

@org.junit.Test
public void test2()
{
	TestJnut t=new TestJnut();
	System.out.println("from test2");
	assertEquals("success",true,t.even(2));
}
@AfterClass
public static void test3()
{
	System.out.println("from after class");
}


}
