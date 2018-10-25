package com.dz.dao;

import com.dz.db.DBHelp;
import com.dz.db.rowmapper.BeanPropertyRowMapper;
import com.dz.entity.User;


public class UserDao {

	DBHelp dbHelp=new DBHelp();
	public void saveU(User user) {
		String sql="insert into t_user(username,password)values(?,?)";
		dbHelp.executeUpdate(sql, user.getUsername(),user.getPassword());		
		
	}
	public User getUser(String name) {
		String sql="select username,password from t_user where username=?";
		return dbHelp.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
	}
	
	
}
