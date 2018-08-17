package com.ycat.service;

import java.util.List;
import java.util.Map;

import com.ycat.pojo.CommentBean;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;
import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;

public interface JokeService {

	EuDataResult getJokeList(int page, int rows) throws Exception;

	JokeBean addJoke(String title, String joke_user_id, String content) throws Exception;

	JokeBean selectJokeBeanById(String jokeId) throws Exception;

	void thumbsJoke(String jokeId, String userId) throws Exception;

	List<JokeLikeBean> selectJokeLikeById(String jokeId) throws Exception;

	CommentBean addComment(String jokeId, String userId, String details) throws Exception;

	EuDataResult getJokeCommentById(int page, int rows, String jokeId) throws Exception;

	void changeJokeLikeCount(Map<String, Object> map) throws Exception;
	
	DeleteResult deleteJokeById(String jokeId)throws Exception;

}
