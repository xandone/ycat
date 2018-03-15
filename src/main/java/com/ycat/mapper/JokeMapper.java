package com.ycat.mapper;

import java.util.List;

import com.ycat.pojo.CommentBean;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;

public interface JokeMapper {
	List<JokeBean> getJokeList();
	
	void addJoke(JokeBean jokeBean);
	
	void thumbsJoke(JokeLikeBean jokeLikeBean);
	
	List<JokeLikeBean> selectJokeLikeById(String jokeId);
	
	void addComment(CommentBean commentBean);
	
	List<CommentBean> getJokeCommentById(String jokeId);
}
