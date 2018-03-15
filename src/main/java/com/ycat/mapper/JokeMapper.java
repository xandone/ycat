package com.ycat.mapper;

import java.util.List;
import java.util.Map;

import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;

public interface JokeMapper {
	List<JokeBean> getJokeList();
	
	void addJoke(JokeBean jokeBean);
	
	void thumbsJoke(JokeLikeBean jokeLikeBean);
	
	List<JokeLikeBean> selectJokeLikeById(String jokeId);
	
	
}
