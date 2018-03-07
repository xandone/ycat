package com.ycat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.mapper.JokeMapper;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.JokeService;

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

}
