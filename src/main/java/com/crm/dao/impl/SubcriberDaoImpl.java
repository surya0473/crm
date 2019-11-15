package com.crm.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.constants.AppConstants;
import com.crm.dao.SubscriberDao;
import com.crm.model.Customer;
import com.crm.util.DaoUtil;
import com.crm.util.DateUtil;

@Repository
public class SubcriberDaoImpl extends DaoUtil implements SubscriberDao {

	@Override
	public Customer createSubcriber(Customer customer) throws Exception {
		Long id = saveAnyEntity(customer);
		customer.setCustId(id);
		return customer;
	}

	@Override
	public Customer modifySubcriber(Customer customer) throws Exception {
		updateAnyEntity(customer);
		return customer;
	}

	@Override
	public List<Customer> getAllSubcribers(String tenantcode) throws Exception {
		return getAnyEntityList(Customer.class, "tenantCode", tenantcode);
	}

	@Override
	public void terminateSubcriber(long custId) throws Exception {
		Customer customer = getAnyEntity(Customer.class, custId);
		customer.setStatus(AppConstants.TERMINATED);
		customer.setDeactiveDate(new Date(DateUtil.getCurrentDate()));
		updateAnyEntity(customer);
	}

	@Override
	public void deActiveSubcriber(long custId) throws Exception {
		Customer customer = getAnyEntity(Customer.class, custId);
		customer.setStatus(AppConstants.DEACTIVE);
		customer.setDeactiveDate(new Date(DateUtil.getCurrentDate()));
		updateAnyEntity(customer);
	}

}
