package com.crm.dao;

import com.crm.exception.UserException;
import com.crm.model.Email;
import com.crm.model.UserEntity;

public interface UserDao {
	UserEntity findByUsername(String username) throws UserException;

	UserEntity saveUser(UserEntity user) throws UserException;

	public String getLastUserId() throws Exception;

	public void changePassword(UserEntity user) throws Exception;

	public void saveEmail(Email email) throws Exception;
	public UserEntity getUser(String username);
}