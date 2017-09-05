package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.UserCircle;

public interface UserCircleDao {

	boolean addUserToCircle(String emailId,String circleName);

	//addUserToCircle and deleteUserFromCircle should have same parameters.
	boolean deleteUserFromCircle(UserCircle userCircle);

	//This method should return only list of email ids.  not List<UserCircle>
	List<UserCircle> getUserByCircle(String circleName);

	boolean isUserExistInCircle(String emailId,String circleName);
}
