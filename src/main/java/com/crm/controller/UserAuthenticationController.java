package com.crm.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.bean.JwtRequestBean;
import com.crm.bean.PasswordChangeBean;
import com.crm.bean.UserBean;
import com.crm.bean.resp.ClientRespBean;
import com.crm.bean.resp.Payload;
import com.crm.bean.resp.UserToken;
import com.crm.config.JwtTokenUtil;
import com.crm.constants.MessageConstants;
import com.crm.model.UserEntity;
import com.crm.service.UserAuthenticationService;

@RestController
@CrossOrigin("*")
public class UserAuthenticationController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserAuthenticationService userDetailsService;

	@Autowired
	Payload payload;

	private int status;
	private String message;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestBean authenticationRequest)
			throws Exception {
		String token = null;
		logger.info(
				"UserAuthenticationController :: createAuthenticationToken :: " + authenticationRequest.getUsername());
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			token = jwtTokenUtil.generateToken(userDetails);
			if (token != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.USER_LOGIN_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = e.getMessage();
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, new UserToken(token)));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserBean user) {
		UserEntity userEntity = null;
		try {
			userEntity = userDetailsService.save(user);
			if (userEntity != null) {
				status = MessageConstants.SUCCESS;
				message = MessageConstants.USER_CREATED_SUCCESS;
			}
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = e.getMessage();
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, userEntity));
	}

	private void authenticate(String username, String password) throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@Valid @RequestBody PasswordChangeBean user) {
		try {
			userDetailsService.changePassword(user);
			status = MessageConstants.SUCCESS;
			message = MessageConstants.DETAILS_CHANGED_SUCCESSFULLY;
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = e.getMessage();
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, null));
	}
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ResponseEntity<?> forgotPassword() {
		try {
			//userDetailsService.changePassword(user);
			status = MessageConstants.SUCCESS;
			message = MessageConstants.DETAILS_CHANGED_SUCCESSFULLY;
		} catch (Exception e) {
			status = MessageConstants.FAILED;
			message = e.getMessage();
		}
		return payload.buildRetunResp(new ClientRespBean(status, message, null));
	}

}