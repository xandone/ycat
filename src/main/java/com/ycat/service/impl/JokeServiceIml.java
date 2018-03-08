package com.ycat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.mapper.JokeMapper;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.JokeService;
import com.ycat.utils.IDUtils;

import config.Config;

@Service
public class JokeServiceIml implements JokeService {
	@Autowired
	JokeMapper jokeMapper;

	public EuDataResult getJokeList(int page, int rows) {

		PageHelper.startPage(page, rows);

		List<JokeBean> list = jokeMapper.getJokeList();

		EuDataResult euDataResult = new EuDataResult();

		euDataResult.setRows(list);
		int total = (int) new PageInfo<JokeBean>(list).getTotal();

		euDataResult.setTotal(total);

		return euDataResult;
	}

	public JokeBean addJoke(String title, String joke_user_id, String content) {
		JokeBean jokeBean = new JokeBean();

		jokeBean.setJoke_id(IDUtils.genItemId());
		jokeBean.setJoke_user_id(Config.AADMIN_ID);
		jokeBean.setTitle(title);
		jokeBean.setContent(content);
		jokeBean.setPost_time(new Date());
		jokeBean.setArticle_comment_count(0);
		jokeBean.setArticle_like_count(0);
		jokeMapper.addJoke(jokeBean);

		return jokeBean;
	}

}
