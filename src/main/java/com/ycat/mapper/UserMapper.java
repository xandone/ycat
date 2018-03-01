package com.ycat.mapper;

import java.util.List;

import com.ycat.pojo.User;

public interface UserMapper {
	void addUser(User user);
	
	List<User> getUserList();

}
