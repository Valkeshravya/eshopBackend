package com.shravya.eshopbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravya.eshopbackend.dao.CategoryDao;
import com.shravya.eshopbackend.model.Category;

@Component("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao
{
   @Autowired
   SessionFactory sessionFactory;
	public boolean saveCategory(Category category) 
	{
		Session session = null;
		/*if(category.getCategoryId()==0)
	    {
	    int id=(int)(Math.random()*10000);
	    category.setCategoryId(id);
	    System.out.println("..........."+id);
	    }
	    */
		System.out.println(sessionFactory);
		try
		{   session=sessionFactory.openSession();
			session.save(category);
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

	public boolean deleteCategory(Category category) 
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		session.delete(category);
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

	public Category getCategory(int categoryId)
	{
		Session session=sessionFactory.openSession();
		Category category=session.get(Category.class,categoryId);
		session.close();
		return category;
	}

	public List<Category> getCategoryList()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from cat");
		List<Category> list=query.list();
		session.close();
		return list;
	}

	@Override
	public boolean editCategory(Category category)
	{
		Session session=null;
		try
		{   session=sessionFactory.openSession();
			session.update(category);
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
