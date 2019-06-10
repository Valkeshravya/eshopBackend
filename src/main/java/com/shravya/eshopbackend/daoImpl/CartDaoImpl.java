package com.shravya.eshopbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravya.eshopbackend.dao.CartDao;
import com.shravya.eshopbackend.model.Cart;
import com.shravya.eshopbackend.model.Product;
import com.shravya.eshopbackend.model.User;
@Component
public class CartDaoImpl implements CartDao
{
@Autowired
SessionFactory sessionFactory;
	public boolean saveCart(Product product, int quantity,String userName) 
	{
		Session session=null;
		
		Cart cart=new Cart();
		cart.setCartId((int)(Math.random()*1000));
		cart.setUserName(userName);
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setProductPrice(product.getProductPrice());
		cart.setProductSupplier(product.getProductSupplier());
	    cart.setProductQuantity(quantity);
	    cart.setTotalPrice((product.getProductPrice())*(cart.getProductQuantity()));
	    try
	    {
	    session=sessionFactory.openSession();
	    session.saveOrUpdate(cart);
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

	public boolean deleteCart(Cart cart)
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		session.delete(cart);
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

	public Cart getCart(int cartId) 
	{
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class,cartId);
		session.close();
		return cart;
	}

	public List<Cart> getCartList(String name)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from carttable where username=:uname");
	
		query.setParameter("uname",name);
		List<Cart> userCartList=query.list();
		session.close();
		return userCartList;
	}

}
