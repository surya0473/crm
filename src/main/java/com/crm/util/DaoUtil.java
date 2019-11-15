package com.crm.util;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoUtil {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;

	public <T> long saveAnyEntity(T entity) throws Exception {
		logger.info("inside saveAnyEntity()");
		Long id = 0l;
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			id = (Long) session.save(entity);
			if (id != null && id > 0) {
				logger.info("Auto generated id:" + id + ", comitting...");
			} else {
				logger.info("Entity not saved, rollbacking ...");
				throw new Exception("Entity not saved.");
			}
			txn.commit();
		} catch (Exception e) {
			logger.error("error while saving entity", e);
			txn.rollback();
			throw e;
		} finally {
		}
		return id.longValue();
	}

	public <T> void saveAnyEntity(List<T> entities) throws Exception {
		logger.info("inside saveAnyEntity()");
		Session session = null;
		Transaction txn = null;
		long id = 0;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			for (T entity : entities) {
				id = (Long) session.save(entity);
				if (id > 0) {
					logger.info("Auto generated id:" + id + ", comitting...");
				} else {
					logger.info("Entity not saved, rollbacking ...");
					throw new Exception("Entity not saved.");
				}
			}
			txn.commit();
			logger.info("Comitted successfully..");
		} catch (Exception e) {
			logger.error("error while saving entity", e);
			txn.rollback();
			throw e;
		} finally {
			session.close();
		}
		return;
	}

	@SuppressWarnings("unchecked")
	public <T, t> t getAnyEntity(Class<?> t, long id) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			return (t) session.get(t, new Long(id));
		} catch (Exception e) {
			logger.info("error while getAnyEntity()", e);
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public <T, t> t getAnyEntityList(Class<?> t) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(t);
			criteria.setReadOnly(true);
			return (t) criteria.list();
		} catch (Exception e) {
			logger.info("error while getAnyEntity()", e);
			throw e;
		} finally {
			session.close();
		}
	}

	public <T> void updateAnyEntity(T entity) throws Exception {
		logger.info("inside dao updateAnyEntity()");
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			session.update(entity);
			txn.commit();
		} catch (Exception e) {
			logger.info("error while updateAnyEntity()", e);
			txn.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public <T> void updateAnyEntity(List<T> entities) throws Exception {
		logger.info("inside dao updateAnyEntity()");
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			for (T entity : entities) {
				session.update(entity);
			}
			txn.commit();
		} catch (Exception e) {
			logger.info("error while updateAnyEntity()", e);
			txn.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public <T> void saveOrUpdateAnyEntity(List<T> entities) throws Exception {
		logger.info("inside dao saveOrUpdateAnyEntity()");
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			for (T entity : entities) {
				session.saveOrUpdate(entity);
			}
			txn.commit();
		} catch (Exception e) {
			logger.info("error while updateAnyEntity()", e);
			txn.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public <T> void saveOrUpdateAnyEntity(T entity) throws Exception {
		logger.info("inside dao saveOrUpdateAnyEntity()");
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(entity);
			txn.commit();
		} catch (Exception e) {
			logger.info("error while saveOrUpdateAnyEntity()", e);
			txn.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public <T, t> t getAnyEntityList(Class<?> t, String propertyName, T value) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(t);
			criteria.add(Restrictions.eq(propertyName, value));
			criteria.setReadOnly(true);
			return (t) criteria.list();
		} catch (Exception e) {
			logger.info("error while getAnyEntityList()", e);
			throw e;
		} finally {
			session.close();
		}
	}

}
