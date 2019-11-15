package com.crm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crm.bean.PasswordChangeBean;
import com.crm.bean.UserBean;
import com.crm.constants.AppConstants;
import com.crm.constants.MessageConstants;
import com.crm.dao.UserDao;
import com.crm.exception.UserException;
import com.crm.model.Email;
import com.crm.model.UserEntity;
import com.crm.util.DateUtil;
import com.crm.util.EmailUtil;
import com.crm.util.GenerateUserIdUtil;

@Service
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private GenerateUserIdUtil userIdtil;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = null;
		try {
			user = userDao.findByUsername(username);
		} catch (UserException e) {
			e.printStackTrace();
		}
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserEntity save(UserBean user) throws Exception {
		UserEntity newUser = new UserEntity();
		//newUser.setUsername(userIdtil.generateUniqueId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setNetworkName(user.getNetworkName());
		newUser.setGender(user.getGender());
		newUser.setEmail(user.getEmail());
		newUser.setContactNo(user.getContactNo());
		return userDao.saveUser(newUser);
	}

	public void changePassword(PasswordChangeBean user) throws Exception {
		UserEntity entity = userDao.findByUsername(user.getUsername());
		if (entity == null) {
			throw new UserException(MessageConstants.INVALID_DETAILS);
		}
		String password = bcryptEncoder.encode(user.getOldPassword());
		if (password.equals(entity.getPassword())) {
			entity.setPassword(bcryptEncoder.encode(user.getNewPassword()));
		} else {
			throw new UserException(MessageConstants.INVALID_PASSWORD);
		}
		userDao.changePassword(entity);
	}

	public void forgotPasswordSendEmail(String userName) throws Exception {
		UserEntity entity = userDao.findByUsername(userName);
		String password = generateCommonLangPassword();
		if (entity == null) {
			throw new UserException(MessageConstants.INVALID_DETAILS);
		} else {
			Email email = new Email();
			email.setContentType(AppConstants.FORGOT_PASSWORD);
			email.setDate(DateUtil.getCurrentDateTime());
			email.setUsername(entity.getUsername());
			email.setValues(password);
			email.setStatus(AppConstants.ACTIVE);
			userDao.saveEmail(email);
			emailUtil.sendEmail(entity.getEmail(), MessageConstants.FORGOT_PASSWORD_BODY + password,
					MessageConstants.FORGOT_PASSWORD_SUBJECT);
		}
	}

	public String generateCommonLangPassword() {
		String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
		String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
		String numbers = RandomStringUtils.randomNumeric(2);
		String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
		String totalChars = RandomStringUtils.randomAlphanumeric(2);
		String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChar)
				.concat(totalChars);
		List<Character> pwdChars = combinedChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.shuffle(pwdChars);
		String password = pwdChars.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
		return password;
	}
	
	public static void main(String[] args) {
		PasswordEncoder bcryptEncoder1=new BCryptPasswordEncoder();
		System.out.println(bcryptEncoder1.encode("surya@123"));
	}

}