package com.ycat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycat.pojo.User;
import com.ycat.pojo.result.BaseResult;
import com.ycat.pojo.result.LoginResult;
import com.ycat.pojo.result.RegistResult;
import com.ycat.service.RegistService;
import com.ycat.service.UserService;
import com.ycat.utils.IDUtils;
import com.ycat.utils.XString;

@Controller
public class RegisterController extends BaseController {
	@Autowired
	RegistService registService;
	@Autowired
	UserService userService;

	public static final String ERROR_CODE_NAME_ERROR = "-1";
	public static final String ERROR_CODE_NICK_ERROR = "-2";
	public static final String ERROR_CODE_NO_ONE_ERROR = "-3";

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	@ResponseBody
	public BaseResult regist(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "nickname", required = true) String nickname) {

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setUser_id(IDUtils.RandomId());

		BaseResult baseResult = new BaseResult();
		RegistResult registResult = new RegistResult();
		List<RegistResult> dataList = new ArrayList<RegistResult>();

		Integer email_code = registService.selectUserByName(name);
		if (email_code != null) {
			baseResult.setCode(ERROR_CODE_NAME_ERROR);
			baseResult.setMsg("该邮箱已注册");
			return baseResult;
		}

		Integer nick_code = registService.selectUserByNick(nickname);
		if (nick_code != null) {
			baseResult.setCode(ERROR_CODE_NICK_ERROR);
			baseResult.setMsg("该昵称已存在");
			return baseResult;
		}
		
		registResult.setUserId(user.getUser_id());
		registResult.setNickName(user.getNickname());

		registService.addUser(user);
		dataList.add(registResult);
		baseResult.setCode(SUCCESS_CODE);
		baseResult.setMsg("注册成功");
		baseResult.setDataList(dataList);

		return baseResult;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public BaseResult login(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password) {

		BaseResult baseResult = new BaseResult();
		LoginResult loginResult = new LoginResult();
		List<LoginResult> dataList = new ArrayList<LoginResult>();

		if (XString.isEmpty(name) || XString.isEmpty(password)) {
			baseResult.setCode(ERROR_CODE);
			baseResult.setMsg("参数为空");
			return baseResult;
		}

		User user = userService.findUserByName(name);
		if (user == null) {
			baseResult.setCode(ERROR_CODE_NO_ONE_ERROR);
			baseResult.setMsg("该账号未注册");
			return baseResult;
		}

		if (!password.equals(user.getPassword())) {
			baseResult.setCode(ERROR_CODE_NAME_ERROR);
			baseResult.setMsg("账号或密码错误");
			return baseResult;
		}

		loginResult.setNickName(user.getNickname());
		loginResult.setUserId(user.getUser_id());
		dataList.add(loginResult);
		baseResult.setCode(SUCCESS_CODE);
		baseResult.setMsg("验证成功");
		baseResult.setDataList(dataList);
		return baseResult;
	}

}
