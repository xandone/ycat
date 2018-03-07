package com.ycat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycat.mapper.UserMapper;
import com.ycat.pojo.User;
import com.ycat.service.RegistService;

@Service
public class RegistServiceImpl implements RegistService {
	@Autowired
	UserMapper userMapper;

	public Integer selectUserByName(String name) {
		Integer id = userMapper.selectUserByName(name);
		return id;
	}

	public Integer selectUserByNick(String nickname) {
		Integer id = userMapper.selectUserByNick(nickname);
		return id;
	}

	public String selectPswByName(String name) {
		String psw=userMapper.selectPswByName(name);
		return psw;
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public String selectNickByName(String name) {
		String nick=userMapper.selectNickByName(name);
		return nick;
	}

}
