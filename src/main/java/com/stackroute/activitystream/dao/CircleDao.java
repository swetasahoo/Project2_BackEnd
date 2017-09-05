
package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Circle;


public interface CircleDao {

	boolean addCircle(Circle circle);
	boolean removeCircle(Circle circle);
	List<Circle> getAllCircles();
	//Need to send only circle ids.  Not details. 
	//this should be getCirclesCreatedByMe.  This method is confusing.
	List<Circle> getCircleByUser(String createdBy);
	public boolean isCircleExist(String circleName);
	
	
}

