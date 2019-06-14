package com.shravya.eshopbackend.dao;

import java.util.List;

import com.shravya.eshopbackend.model.Product;

public interface ProductDao 
{
	boolean saveProduct(Product product);
	boolean editProduct(Product product);
	    boolean deleteProduct(Product product);
	    
	    Product getProduct(int productId);
	    
	   List<Product>    getProductList();
}
