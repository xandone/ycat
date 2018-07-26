package com.ycat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ycat.pojo.CommentBean;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;
import com.ycat.pojo.result.BaseResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.pojo.result.FileUpResult;
import com.ycat.service.ImageService;
import com.ycat.service.JokeService;

@Controller
public class JokeController extends BaseController {
	@Autowired
	JokeService jokeService;
	@Autowired
	ImageService imageService;

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
			// 已点赞
			baseResult.setCode(ERROR_CODE);
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("joke_id", jokeId);
			map.put("article_like_count", 1);
			jokeService.changeJokeLikeCount(map);
			//
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

		JokeBean jokeBean = jokeService.selectJokeBeanById(jokeId);
		List<JokeBean> data = new ArrayList<>();
		data.add(jokeBean);

		List<JokeLikeBean> likeBeans = jokeService.selectJokeLikeById(jokeId);
		for (int i = 0; i < likeBeans.size(); i++) {
			if (jokeUserId.equals(likeBeans.get(i).getJoke_user_id())) {
				// 已点赞
				isThumbs = true;
				break;
			}
		}
		if (isThumbs) {
			// 已点赞
			baseResult.setCode(ERROR_CODE);
		} else {
			baseResult.setCode(SUCCESS_CODE);
		}
		baseResult.setDataList(data);
		return baseResult;
	}

	@RequestMapping("joke/comment/add")
	@ResponseBody
	public BaseResult addComment(String jokeId, String userId, String details) {

		BaseResult baseResult = new BaseResult();
		List<CommentBean> dataList = new ArrayList<CommentBean>();
		try {
			CommentBean commentBean = jokeService.addComment(jokeId, userId, details);
			baseResult.setCode(SUCCESS_CODE);
			dataList.add(commentBean);
			baseResult.setDataList(dataList);
			return baseResult;
		} catch (Exception e) {
			e.printStackTrace();
			baseResult.setCode(ERROR_CODE);
			return baseResult;
		}

	}

	@RequestMapping("joke/comment/list")
	@ResponseBody
	public EuDataResult getJokeCommentById(Integer page, Integer rows, String jokeId) {

		EuDataResult euDataResult = jokeService.getJokeCommentById(page, rows, jokeId);

		return euDataResult;

	}

	@RequestMapping("upload")
	public BaseResult upImage(@RequestParam(value = "file") MultipartFile file) throws Exception {
		System.out.println("upload..............");
		if (file == null) {
			System.out.println("上传文件为空");
			return null;
		}
		BaseResult baseResult = new BaseResult();
		List<FileUpResult> dataList = new ArrayList<>();
		FileUpResult fileUpResult = imageService.upfile(file);

		if (fileUpResult != null) {
			baseResult.setCode(SUCCESS_CODE);
			dataList.add(fileUpResult);
			baseResult.setDataList(dataList);
		} else {
			baseResult.setCode(ERROR_CODE);
		}

		return baseResult;

	}
}
