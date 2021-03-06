package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.User;

public interface UserDao {
	 boolean save(User user);
	 boolean update(User user);
	 User get(String emailId);
	 List<User> list();
	 User validate(String emailId,String password);
	
	//This method is not required as you have get(String emailID).
	 boolean isUserExist(String emailId);
}
