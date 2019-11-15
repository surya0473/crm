package com.crm.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.bean.resp.DashBoardRespBean;
import com.crm.dao.DashBoardDao;

@Service
public class DashBoardService {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DashBoardDao dao;

	public DashBoardRespBean getDashBoardDetails(String tenantcode) throws Exception {
		return dao.getDashBoardDetails(tenantcode);
	}
}
