package com.crm.dao;

import java.util.List;

import com.crm.model.Customer;

public interface SubscriberDao {

	Customer createSubcriber(Customer customer) throws Exception;

	Customer modifySubcriber(Customer customer) throws Exception;

	List<Customer> getAllSubcribers(String tenantcode) throws Exception;

	void terminateSubcriber(long custId) throws Exception;

	void deActiveSubcriber(long custId) throws Exception;

}
