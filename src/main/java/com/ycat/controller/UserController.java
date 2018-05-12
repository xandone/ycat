package com.ycat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ycat.pojo.User;
import com.ycat.pojo.result.BaseResult;
import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.pojo.result.LoginResult;
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

	@RequestMapping("/user/upIcon")
	@ResponseBody
	public BaseResult upfileByUser(@RequestParam(value = "file") MultipartFile file, String userId) throws Exception {

		if (userId == null || userId == "") {
			userId = "123456";
		}

		System.out.println(userId);

		if (file == null) {
			System.out.println("上传文件为空");
			return null;
		}
		BaseResult baseResult = new BaseResult();
		List<LoginResult> dataList = new ArrayList<>();
		User user = userService.addIcon(file, userId);

		LoginResult loginResult = new LoginResult();
		loginResult.setIconUrl(user.getUser_icon());

		if (user != null) {
			baseResult.setCode(SUCCESS_CODE);
			dataList.add(loginResult);
			baseResult.setDataList(dataList);

		} else {
			baseResult.setCode(ERROR_CODE);
		}
		return baseResult;

	}

}
