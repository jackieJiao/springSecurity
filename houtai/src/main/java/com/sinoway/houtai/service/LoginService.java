package com.sinoway.houtai.service;

import com.sinoway.houtai.entitys.User;

public interface LoginService {

	
	public abstract User selectUserForLogin(String userName, String userPsw);

}