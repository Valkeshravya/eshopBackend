package com.shravya.eshopbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravya.eshopbackend.dao.OrderDao;
import com.shravya.eshopbackend.model.UserOrder;
@Component
public class OrderDaoImpl implements OrderDao
{
@Autowired
SessionFactory sessionFactory;
	@Override
	public boolean saveOrder(UserOrder userOrder) 
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		session.save(userOrder);
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

	@Override
	public List<UserOrder> getMyOrders(String userName)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Userorder where user.email=:em");
		query.setParameter("em",userName);
		List<UserOrder> list=(List<UserOrder>)query.list();
		return list;
	}

}
