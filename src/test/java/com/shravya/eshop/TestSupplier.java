package com.shravya.eshop;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shravya.eshopbackend.daoImpl.SupplierDaoImpl;
import com.shravya.eshopbackend.model.Supplier;

public class TestSupplier
{
	static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	 static	SupplierDaoImpl supplierDaoImpl;
	  @BeforeClass
		public static void test1()
		{
			annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
			annotationConfigApplicationContext.scan("com.shravya.eshopbackend");
			annotationConfigApplicationContext.refresh();
		    supplierDaoImpl=(SupplierDaoImpl)annotationConfigApplicationContext.getBean("supplierDaoImpl");
	        System.out.println("before");
		}

		@Test
		public void test2()
		{
		    Supplier supplier=new Supplier();
		    supplier.setSupplierId(4);
		    supplier.setSupplierName("name");
		    supplier.setSupplierDescription("bye");
		    supplier.setSupplierAddress("hyd");
			assertEquals("yes", true,supplierDaoImpl.saveSupplier(supplier));
			System.out.println(supplierDaoImpl);
		}
		@Test
		public void test3()
		{
			 Supplier supplier=new Supplier();
			    supplier.setSupplierId(4);
			    supplier.setSupplierName("name");
			    supplier.setSupplierDescription("bye");
			    supplier.setSupplierAddress("hyd");
				assertEquals("negative",false,supplierDaoImpl.saveSupplier(supplier));
				System.out.println(supplierDaoImpl);		}

}
