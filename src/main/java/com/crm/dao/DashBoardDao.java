package com.crm.dao;

import com.crm.bean.resp.DashBoardRespBean;

public interface DashBoardDao {
	public DashBoardRespBean getDashBoardDetails(String tenantcode) throws Exception;
}
