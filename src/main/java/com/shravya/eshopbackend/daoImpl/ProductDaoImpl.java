package com.shravya.eshopbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravya.eshopbackend.dao.ProductDao;
import com.shravya.eshopbackend.model.Product;
@Component
public class ProductDaoImpl implements ProductDao
{
@Autowired
SessionFactory sessionFactory;
	public boolean saveProduct(Product product)
	{
        Session session = null;
		
		System.out.println(sessionFactory);
		try
		{   session=sessionFactory.openSession();
			session.save(product);
			Transaction transaction=session.beginTransaction();
			transaction.commit();
			System.out.println("try");
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("catch");
			return false;
		}
		finally
		{
			session.close();
		}
	}

	public boolean deleteProduct(Product product) 
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		session.delete(product);
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

	public Product getProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,productId);
		session.close();
		return product;
	}

	public List<Product> getProductList()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from pro");
		List<Product> list=query.list();
		session.close();
		return list;
	}

	@Override
	public boolean editProduct(Product product) 
	{
		Session session=null;
		try
		{   session=sessionFactory.openSession();
			session.update(product);
			Transaction transaction=session.beginTransaction();
			transaction.commit();
			System.out.println("try");
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("catch");
			return false;
		}
		finally
		{
			session.close();
		}


	}

}
