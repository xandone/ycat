package com.ycat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;
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

		JokeBean jokeBean = jokeService.addJoke(title, joke_user_id, content);
		BaseResult baseResult = new BaseResult();
		List<JokeBean> list = new ArrayList<JokeBean>();
		list.add(jokeBean);
		baseResult.setDataList(list);
		baseResult.setCode(SUCCESS_CODE);

		return baseResult;

	}

	@RequestMapping("joke/thumbs")
	@ResponseBody
	public BaseResult thumbsJoke(String jokeId, String jokeUserId) {
		BaseResult baseResult = new BaseResult();
		boolean isThumbs = false;
		List<JokeLikeBean> likeBeans = jokeService.selectJokeLikeById(jokeId);
		for (int i = 0; i < likeBeans.size(); i++) {
			if (jokeUserId.equals(likeBeans.get(i).getJoke_user_id())) {
				// 已点赞
				isThumbs = true;
				break;
			}
		}
		if (isThumbs) {
			baseResult.setCode(ERROR_CODE);
		} else {
			jokeService.thumbsJoke(jokeId, jokeUserId);
			baseResult.setCode(SUCCESS_CODE);
		}

		return baseResult;
	}
	
	
	@RequestMapping("joke/thumbs/self")
	@ResponseBody
	public BaseResult getThumbsJoke(String jokeId, String jokeUserId) {
		BaseResult baseResult = new BaseResult();
		boolean isThumbs = false;
		List<JokeLikeBean> likeBeans = jokeService.selectJokeLikeById(jokeId);
		for (int i = 0; i < likeBeans.size(); i++) {
			if (jokeUserId.equals(likeBeans.get(i).getJoke_user_id())) {
				// 已点赞
				isThumbs = true;
				break;
			}
		}
		if (isThumbs) {
			baseResult.setCode(ERROR_CODE);
		} else {
			baseResult.setCode(SUCCESS_CODE);
		}

		return baseResult;
	}


}
