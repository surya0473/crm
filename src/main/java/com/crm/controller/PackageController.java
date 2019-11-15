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
import com.crm.model.PackageEntity;
import com.crm.service.PackageService;

@RestController
@CrossOrigin("*")
@RequestMapping("/packages")
public class PackageController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private Payload payload;

	@Autowired
	private PackageService service;

	private int status;
	private String message;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createPackage(PackageEntity packageEntity) throws Exception {
		logger.info("PackageController :: createPackage ");
		PackageEntity entity = null;
		try {
			entity = service.createPackage(packageEntity);
			if (entity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.PACKAGE_CREATED_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.PACKAGE_CREATION_FAILED;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, entity));
	}

	@PostMapping(value = "/modify")
	public ResponseEntity<?> modifyPackage(PackageEntity packageEntity) throws Exception {
		logger.info("PackageController :: createPackage ");
		PackageEntity entity = null;
		try {
			entity = service.modifyPackage(packageEntity);
			if (entity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.PACKAGE_UPDATE_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.PACKAGE_UPDATE_FAILED;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, entity));

	}

	@GetMapping(value = "/getpackages")
	public ResponseEntity<?> getPackages(String tenantcode) {
		logger.info("PackageController :: getPackages ");
		List<PackageEntity> list = null;
		try {
			list = service.getPackages(tenantcode);
			if (list != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.PACKAGES_FOUND;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = MessageConstants.PACKAGES_NOT_FOUND;
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, list));
	}

}
