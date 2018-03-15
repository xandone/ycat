package com.ycat.service;

import java.util.List;

import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;
import com.ycat.pojo.result.EuDataResult;

public interface JokeService {

	EuDataResult getJokeList(int page, int rows);

	JokeBean addJoke(String title, String joke_user_id, String content);
	
	void thumbsJoke(String jokeId,String userId) ;
	
	List<JokeLikeBean> selectJokeLikeById(String jokeId) ;
}
