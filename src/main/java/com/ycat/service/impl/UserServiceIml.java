package com.ycat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.mapper.UserMapper;
import com.ycat.pojo.User;
import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.UserService;

@Service
public class UserServiceIml implements UserService {
	@Autowired
	UserMapper userMapper;

	public EuDataResult getUserList(int page, int rows) {
		// TODO Auto-generated method stub

		PageHelper.startPage(page, rows);

		List<User> list = userMapper.getUserList();

		EuDataResult euDataResult = new EuDataResult();

		euDataResult.setRows(list);
		int total = (int) new PageInfo<User>(list).getTotal();

		euDataResult.setTotal(total);

		return euDataResult;

	}

	public DeleteResult deleteUser(String name) {
		userMapper.deleteUser(name);
		DeleteResult deleteResult = new DeleteResult();
		return deleteResult;
	}

	public User selectUserById(String userId) {
		User user = userMapper.selectUserById(userId);
		return user;
	}

	public User findUserByName(String userName) {
		User user = userMapper.findUserByName(userName);
		return user;
	}

}
