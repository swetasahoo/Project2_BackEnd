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

import com.stackroute.activitystream.dao.MessageDao;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.UserMessage;
//See the comments on MessageDao and modified accordingly.
@Repository("messageDAO")
@Component
@Transactional
public class MessageDaoImpl implements MessageDao{

//Use private access specifiers
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	Message message;
	public MessageDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		
		this.sessionFactory=sessionFactory;
	}
	public boolean sendMessage(Message message) {
		try {
		
			if(message.getCircleName()!="" && message.getSenderEmailId()!="")
			{
			sessionFactory.getCurrentSession().save(message);
			
			return true;
			}
		
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Message").list();
	}
	@Override
	public List<Message> getAllMessageByCircleName(String circleName) {
		String hql="from Message where circleName='"+circleName+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Message> messageList= query.list();
		return messageList;
	}
	


	
	
	
	

}
