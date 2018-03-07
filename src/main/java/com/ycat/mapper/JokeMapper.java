package com.ycat.mapper;

import java.util.List;

import com.ycat.pojo.JokeBean;

public interface JokeMapper {
	List<JokeBean> getJokeList();
	
	void addJoke(JokeBean jokeBean);
}
