package com.shravya.eshopbackend.dao;

import java.util.List;

import com.shravya.eshopbackend.model.UserOrder;

public interface OrderDao
{
	boolean saveOrder(UserOrder userOrder);
	List<UserOrder> getMyOrders(String userName);
}
