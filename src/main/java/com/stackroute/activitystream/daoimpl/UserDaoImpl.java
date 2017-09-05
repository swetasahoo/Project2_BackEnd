package com.stackroute.activitystream.daoimpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.User;

@Repository(value = "userDAO")
@Component
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	public UserDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	public boolean save(User user) {

		try {

			user.setActive();
			Session session = sessionFactory.openSession();
			session.save(user);
			session.close();
			return true;

		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {

		try {

			if (isUserExist(user.getEmailId())) {
				Session session = sessionFactory.openSession();
				session.update(user);
				session.close();
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;

		}
		return false;
	}

	public User get(String emailId) {

		user = (User) sessionFactory.getCurrentSession().get(User.class, emailId);
		return user;

	}

	public List<User> list() {

		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	public User validate(String emailId, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Expression.eq("emailId", emailId));
		criteria.add(Expression.eq("password", password));
		return (User) criteria.uniqueResult();

	}

	public boolean isUserExist(String emailId) {
		String hql = "from User where emailId='" + emailId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if ((User) query.uniqueResult() != null) {
			return true;
		}

		return false;
	}

}
