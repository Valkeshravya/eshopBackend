package com.shravya.eshopbackend.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravya.eshopbackend.dao.UserDao;
import com.shravya.eshopbackend.model.User;
@Component
public class UserDaoImpl implements UserDao
{
@Autowired
SessionFactory sessionFactory;
	public boolean addUser(User user)
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		session.saveOrUpdate(user);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return true;
		}
		catch (Exception e) {
		return false;
		}
		finally
		{
			session.close();
		}
	}
		

	public boolean checkLogin(User user)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from usertable where email=:em and password=:pw");
		query.setParameter("em",user.getEmail());
		query.setParameter("pw",user.getPassword());
		Object object=query.uniqueResult();
		User user2=(User)object;
		session.close();
		if(user2==null)
		{
			return false;
		}
		else {
			return true;
		}
		

	}

}
