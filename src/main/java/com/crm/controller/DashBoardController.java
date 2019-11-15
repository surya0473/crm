package com.crm.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.bean.resp.ClientRespBean;
import com.crm.bean.resp.DashBoardRespBean;
import com.crm.bean.resp.Payload;
import com.crm.constants.MessageConstants;
import com.crm.service.DashBoardService;

@RestController
@CrossOrigin("*")
@RequestMapping("/dashboard")
public class DashBoardController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private Payload payload;

	@Autowired
	private DashBoardService service;

	private int status;
	private String message;

	@GetMapping(value = "/getpackages")
	public ResponseEntity<?> getPackages(String tenantcode) {
		logger.info("DashBoardController :: getPackages ");
		DashBoardRespBean resp = null;
		try {
			resp = service.getDashBoardDetails(tenantcode);
			if (resp != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.DASHBOARD_DETAILS_FOUND;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.DASHBOARD_DETAILS_NOT_FOUND;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, resp));
	}

}
