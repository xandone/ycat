package com.ycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
