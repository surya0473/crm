package com.crm.constants;

public interface MessageConstants {

	String USER_CREATION_FAILED = "Unable to create User";

	// status response
	int SUCCESS = 200;
	int FAILED = 500;
	int UNAUTHORIZED = 400;

	// response messages
	String USER_CREATED_SUCCESS = "User created succesfully";
	String USER_LOGIN_SUCCESS = "User Logged-in succesfully";
	String USER_LOGIN_FAILED = "Unable to Logged-in User";
	String INVALID_DETAILS = "Invalid credentials";
	String INVALID_PASSWORD = "Invalid PASSWORD";
	String DETAILS_CHANGED_SUCCESSFULLY="Details changed successfully";

	String PACKAGE_CREATED_SUCCESS = "Package created succesfully";
	String PACKAGE_CREATION_FAILED = "Unable to create package";
	String PACKAGE_UPDATE_SUCCESS = "Package updated succesfully";
	String PACKAGE_UPDATE_FAILED = "Unable to update package";
	String PACKAGES_FOUND = "Packages found";
	String PACKAGES_NOT_FOUND = "Unable to find packages";
	String DASHBOARD_DETAILS_FOUND = "Dashboard found";
	String DASHBOARD_DETAILS_NOT_FOUND = "Unable to find Dashboard details";
	
	String SUBSCRIBER_CREATED_SUCCESS = "Subscriber created succesfully";
	String SUBSCRIBER_CREATION_FAILED = "Unable to create Subscriber";
	String SUBSCRIBER_UPDATE_SUCCESS = "Subscriber updated succesfully";
	String SUBSCRIBER_UPDATE_FAILED = "Unable to update Subscriber";
	String SUBSCRIBER_FOUND = "Subscribers found";
	String SUBSCRIBER_NOT_FOUND = "Unable to find Subscribers";
	
	
	String FORGOT_PASSWORD_SUBJECT="Reset Your Crm Password";
	String FORGOT_PASSWORD_BODY="Your Crm Password is :: ";

}
