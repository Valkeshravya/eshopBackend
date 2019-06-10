package com.shravya.eshopbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravya.eshopbackend.dao.SupplierDao;
import com.shravya.eshopbackend.model.Supplier;
@Component("supplierDaoImpl")
public class SupplierDaoImpl implements SupplierDao
{
  @Autowired
  SessionFactory sessionFactory;
	public boolean saveSupplier(Supplier supplier)
	{
		Session session=null;
		if(supplier.getSupplierId()==0)
	    {
	    int id=(int)(Math.random()*10000);
	    supplier.setSupplierId(id);
	    System.out.println("..........."+id);
	    }
		try
		{
		session=sessionFactory.openSession();
		session.saveOrUpdate(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		System.out.println("try");
		return true;
		}
		catch (Exception e) 
		{
			System.out.println("catch");
			return false;
		}
		finally 
		{
			session.close();
		}
	}

	public boolean deleteSupplier(Supplier supplier)
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		session.delete(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return true;
		}
		catch (Exception e) 
		{
		return false;
		}
		finally
		{
			session.close();
		}
	
	}

	public Supplier getSupplier(int supplierId)
	{
		
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	public List<Supplier> getSupplierList() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from sup");
		List<Supplier> list=query.list();
		session.close();
		return list;	
		
	}

}
