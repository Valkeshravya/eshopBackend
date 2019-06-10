package com.shravya.eshopbackend.dao;

import java.util.List;

import com.shravya.eshopbackend.model.Cart;
import com.shravya.eshopbackend.model.Product;

public interface CartDao
{
	 boolean saveCart(Product product, int quantity,String userName);
	    
	    boolean deleteCart(Cart cart);
	    
	    Cart getCart(int cartId);
	    
	   List<Cart>    getCartList(String name);
}
