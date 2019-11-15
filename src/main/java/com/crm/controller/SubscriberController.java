package com.crm.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.bean.resp.ClientRespBean;
import com.crm.bean.resp.Payload;
import com.crm.constants.MessageConstants;
import com.crm.model.Customer;
import com.crm.service.SubscriberService;

@RestController
@CrossOrigin("*")
@RequestMapping("/subscriber")
public class SubscriberController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private Payload payload;

	@Autowired
	private SubscriberService service;

	private int status;
	private String message;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createSubscriber(Customer customer) throws Exception {
		logger.info("SubscriberController :: createSubscriber ");
		Customer entity = null;
		try {
			entity = service.createSubcriber(customer);
			if (entity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.SUBSCRIBER_CREATED_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.SUBSCRIBER_CREATION_FAILED;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, entity));
	}

	@PostMapping(value = "/modify")
	public ResponseEntity<?> modifySubscriber(Customer packageEntity) throws Exception {
		logger.info("SubscriberController :: modifySubscriber ");
		Customer entity = null;
		try {
			entity = service.modifySubcriber(packageEntity);
			if (entity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.SUBSCRIBER_UPDATE_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.SUBSCRIBER_UPDATE_FAILED;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, entity));

	}

	@GetMapping(value = "/getsubscribers")
	public ResponseEntity<?> getSubscribers(String tenantcode) {
		logger.info("SubscriberController :: getSubscribers ");
		List<Customer> list = null;
		try {
			list = service.getAllSubcribers(tenantcode);
			if (list != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.SUBSCRIBER_FOUND;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.SUBSCRIBER_NOT_FOUND;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, list));
	}

	@PostMapping(value = "/terminate")
	public ResponseEntity<?> terminateSubscriber(Customer packageEntity) throws Exception {
		logger.info("SubscriberController :: terminateSubscriber ");
		Customer entity = null;
		try {
			entity = service.modifySubcriber(packageEntity);
			if (entity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.SUBSCRIBER_UPDATE_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.SUBSCRIBER_UPDATE_FAILED;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, entity));

	}

	@PostMapping(value = "/deactive")
	public ResponseEntity<?> deactiveSubscriber(Customer packageEntity) throws Exception {
		logger.info("SubscriberController :: deactiveSubscriber ");
		Customer entity = null;
		try {
			entity = service.modifySubcriber(packageEntity);
			if (entity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.SUBSCRIBER_UPDATE_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.SUBSCRIBER_UPDATE_FAILED;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, entity));

	}

}
