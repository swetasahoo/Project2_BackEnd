package com.stackroute.activitystream.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.UserCircleDao;

import com.stackroute.activitystream.model.UserCircle;

@Repository("userCircleDAO")
@Component
@Transactional
public class UserCircleDaoImpl implements UserCircleDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserCircle userCircle;
	
	public UserCircleDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}

	public boolean addUserToCircle(String emailId,String circleName) {
		
		try {
			if(!isUserExistInCircle(emailId,circleName))
			{
			userCircle.setUserSubscribeDate();
			userCircle.setCircleName(circleName);
			userCircle.setEmailId(emailId);
			sessionFactory.getCurrentSession().save(userCircle);

			return true;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
		
	return false;
	}

	public boolean deleteUserFromCircle(UserCircle userCircle) {
		try{
			if(isUserExistInCircle(userCircle.getEmailId(), userCircle.getCircleName()))
			{
			sessionFactory.getCurrentSession().delete(userCircle);
			return true;
			}
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		return false;
	}

	public List<UserCircle> getUserByCircle(String circleName) {
		
		String hql="from UserCircle  where circleName= '" + circleName+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserCircle> list = (List<UserCircle>) query.list();
		return list;
	}

	public boolean isUserExistInCircle(String emailId,String circleName) {
		String hql="from UserCircle where circleName='"+circleName+"' and emailId='"+emailId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
	UserCircle userCirle1=(UserCircle) query.uniqueResult();
		if(userCirle1!=null)
		{
			return true;
		}
		
		return false;
	}

	

	

	
	
}
