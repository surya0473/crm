package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.SubscriberDao;
import com.crm.model.Customer;

@Service
public class SubscriberService {
	@Autowired
	private SubscriberDao dao;

	public Customer createSubcriber(Customer customer) throws Exception {
		return dao.createSubcriber(customer);
	}

	public Customer modifySubcriber(Customer customer) throws Exception {
		return dao.modifySubcriber(customer);

	}

	public List<Customer> getAllSubcribers(String tenantcode) throws Exception {
		return dao.getAllSubcribers(tenantcode);
	}

	public void terminateSubcriber(long custId) throws Exception {
		dao.terminateSubcriber(custId);
	}

	public void deActiveSubcriber(long custId) throws Exception {
		dao.deActiveSubcriber(custId);
	}

}
