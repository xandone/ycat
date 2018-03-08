package com.ycat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycat.pojo.JokeBean;
import com.ycat.pojo.result.BaseResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.JokeService;

@Controller
public class JokeController extends BaseController {
	@Autowired
	JokeService jokeService;

	@RequestMapping("/joke/list")
	@ResponseBody
	public EuDataResult getJokeList(Integer page, Integer rows) {

		EuDataResult euDataResult = jokeService.getJokeList(page, rows);

		return euDataResult;

	}

	@RequestMapping("/joke/add")
	@ResponseBody
	public BaseResult addJoke(String title, String joke_user_id, String content) {

		System.out.println("基拉》。");
		JokeBean jokeBean = jokeService.addJoke(title, joke_user_id, content);
		BaseResult baseResult = new BaseResult();
		List<JokeBean> list = new ArrayList<JokeBean>();
		list.add(jokeBean);
		baseResult.setDataList(list);
		baseResult.setCode(SUCCESS_CODE);
	
		return baseResult;

	}

}
