package com.ycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.UserService;

@Controller
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	@RequestMapping("/item/list")
	@ResponseBody
	public EuDataResult getUserList(Integer page, Integer rows) {

		EuDataResult euDataResult = userService.getUserList(page, rows);

		return euDataResult;

	}

	@RequestMapping(value = "/rest/item/delete", method = RequestMethod.POST)
	@ResponseBody
	public DeleteResult deleteUser(String name) {
		DeleteResult deleteResult = null;
		try {
			deleteResult = userService.deleteUser(name);
			deleteResult.setCode(SUCCESS_CODE);
			return deleteResult;
		} catch (Exception e) {
			e.printStackTrace();
			return deleteResult;
		}
	}

}
