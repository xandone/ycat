package com.ycat.service;

import com.ycat.pojo.User;

public interface RegistService {

	Integer selectUserByName(String name) throws Exception;

	Integer selectUserByNick(String nickname) throws Exception;

	String selectPswByName(String name) throws Exception;

	String selectNickByName(String name) throws Exception;

	void addUser(User user) throws Exception;

}
