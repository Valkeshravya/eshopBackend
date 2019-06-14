package com.shravya.eshopbackend.dao;

import java.util.List;

import com.shravya.eshopbackend.model.Cart;

public interface CartDao
{
	 boolean saveCart(Cart cart);
	   boolean editCart(Cart cart);
	    boolean deleteCart(Cart cart);
	    Cart getCart(int cartId);
	   List<Cart> getCartList(String userName);
}
