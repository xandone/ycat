package com.ycat.mapper;

import java.util.List;

import com.ycat.pojo.User;

public interface UserMapper {
	void addUser(User user);

	List<User> getUserList();

	Integer selectUserByName(String name);

	Integer selectUserByNick(String nickname);
	
	String selectPswByName(String name);
	
	String selectNickByName(String name);
	
	String selectNickById(String user_id);
	
	User selectUserById(String user_id);

	void deleteUser(String name);

}
