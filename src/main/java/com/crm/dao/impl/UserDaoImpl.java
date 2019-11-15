package com.crm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.constants.MessageConstants;
import com.crm.constants.QueryConstants;
import com.crm.dao.UserDao;
import com.crm.exception.UserException;
import com.crm.model.Email;
import com.crm.model.UserEntity;
import com.crm.util.DaoUtil;

@SuppressWarnings("deprecation")
@Repository
public class UserDaoImpl extends DaoUtil implements UserDao {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserEntity findByUsername(String username) {
		UserEntity produObj = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(QueryConstants.GET_USER_BY_USERNAME);
			query.setString(QueryConstants.username, username);
			produObj = (UserEntity) query.uniqueResult();
		} catch (Exception ex) {
			logger.error("error while findByUsername:", ex);
			throw ex;
		}
		return produObj;
	}

	@Override
	public UserEntity saveUser(UserEntity user) throws UserException {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Long id = (Long) session.save(user);
			if (id > 0) {
				user.setId(id);
			} else {
				throw new UserException(MessageConstants.USER_CREATION_FAILED);
			}
		} catch (Exception ex) {
			logger.error("error while saveUser:", ex);
			throw ex;
		} finally {
			session.close();
		}
		return user;
	}

	public String getLastUserId() {
		String lastUserId = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UserEntity u order by u.id desc");
			@SuppressWarnings("unchecked")
			List<UserEntity> userList = (List<UserEntity>) query.list();
			if (userList != null && userList.size() > 0) {
				return userList.get(0).getUsername();
			}
		} catch (Exception ex) {
			logger.error("error while fetching last userId:", ex);
		} finally {
			session.close();
		}
		return lastUserId;
	}

	@Override
	public void changePassword(UserEntity user) throws Exception {
		updateAnyEntity(user);
	}

	public void saveEmail(Email email) throws Exception {
		saveAnyEntity(email);
	}

}
