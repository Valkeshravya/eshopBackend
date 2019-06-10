package com.shravya.eshopbackend.dao;

import com.shravya.eshopbackend.model.User;

public interface UserDao
{
	public boolean addUser(User user);
    public boolean checkLogin(User user);
}
