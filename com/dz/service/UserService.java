package com.dz.service;

import com.dz.dao.UserDao;
import com.dz.entity.User;

public class UserService {
	private UserDao uDao=new UserDao();
	public void saveU(User user) {
		uDao.saveU(user);
		
	}
	public User getUser(String name) {
		
		return uDao.getUser(name);
	}

}
