package com.ycat.service;



import com.ycat.pojo.User;

public interface RegistService {
	
	Integer selectUserByName(String name);

	Integer selectUserByNick(String nickname);
	
	String selectPswByName(String name);
	
	String selectNickByName(String name);
	
	void addUser(User user);


}
