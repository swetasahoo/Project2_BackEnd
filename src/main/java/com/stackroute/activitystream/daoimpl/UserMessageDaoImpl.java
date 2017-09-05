package com.stackroute.activitystream.daoimpl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.UserMessageDao;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.UserMessage;


@Repository("userMessageDAO")
@Component
@Transactional
public class UserMessageDaoImpl implements UserMessageDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserMessage userMessage;
	
	public UserMessageDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean sendMessage(UserMessage userMessage) {
		
		try {
			if(userMessage.getReceiverEmailId()!="" && userMessage.getSenderEmailId()!="")
			{
			Session session=sessionFactory.openSession();
			session.save(userMessage);
			session.flush();
			session.close();
			return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteMessage(int messageId, String emailId) {
		try {
			
			if(isMessageExist(messageId,emailId))
			{
			sessionFactory.getCurrentSession().delete(getMessageByMessageId(messageId));
			return true;
			}
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	private boolean isMessageExist(int messageId, String emailId) {
		String hql="from UserMessage where messageId="+messageId +"and receiverEmailId='"+emailId+"'";
	    Query query=sessionFactory.getCurrentSession().createQuery(hql);
	    List<UserMessage> userMessage=(List<UserMessage>) query.list();
	    if(userMessage !=null)
	    {
	    	return true;
	    }
		return false;
	}

	@Override
	public List<UserMessage> getMyMessage(String emailId) {
		String hql="from UserMessage where receiverEmailId='"+emailId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<UserMessage> userMessages=query.list();
		return userMessages;
	}

	@Override
	public UserMessage getMessageByMessageId(int messageId) {
		return (UserMessage) sessionFactory.getCurrentSession().get(UserMessage.class, messageId);
	}

	

	

}
