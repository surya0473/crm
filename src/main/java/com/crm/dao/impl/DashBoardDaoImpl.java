package com.crm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.bean.resp.DashBoardRespBean;
import com.crm.constants.QueryConstants;
import com.crm.dao.DashBoardDao;

@SuppressWarnings("deprecation")
@Repository
public class DashBoardDaoImpl implements DashBoardDao {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private SessionFactory sessionFactory;

	public DashBoardRespBean getDashBoardDetails(String tenantcode) throws Exception {
		DashBoardRespBean resp = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(QueryConstants.GET_USER_BY_USERNAME);
			query.setString(QueryConstants.username, tenantcode);
			List<Object[]> respList = query.list();
			if (respList != null && !respList.isEmpty()) {
				resp = new DashBoardRespBean();
				Object[] obj = respList.get(0);
				if (obj != null) {
					resp.setActiveCustomers(0);
					resp.setInActiveCustomers(0);
					resp.setPaidAmount(0);
					resp.setTotalBill(0);
					resp.setTotalCustomers(0);
					resp.setUnPaidAmount(0);
				}
			}
		} catch (Exception ex) {
			logger.error("error while getDashBoardDetails:", ex);
			throw ex;
		} finally {
			session.close();
		}
		return resp;
	}
}
