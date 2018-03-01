package com.ycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/item/list")
	@ResponseBody
	public EuDataResult getUserList(Integer page, Integer rows) {
		
		EuDataResult euDataResult = userService.getUserList(page, rows);

		return euDataResult;

	}

}
