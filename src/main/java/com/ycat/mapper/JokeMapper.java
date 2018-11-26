package com.ycat.mapper;

import java.util.List;
import java.util.Map;

import com.ycat.pojo.CommentBean;
import com.ycat.pojo.HeadArticleBean;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;

public interface JokeMapper {
	List<JokeBean> getJokeList();

	void addJoke(JokeBean jokeBean);

	JokeBean selectJokeBeanById(String jokeId);

	void thumbsJoke(JokeLikeBean jokeLikeBean);

	List<JokeLikeBean> selectJokeLikeById(String jokeId);

	void addComment(CommentBean commentBean);

	List<CommentBean> getJokeCommentById(String jokeId);

	void changeJokeLikeCount(Map<String, Object> map);

	void deleteJokeById(String id);

	void deleteJokeCommentById(String id);

	List<HeadArticleBean> getArticleList();
	
	void addAticle(HeadArticleBean bean);
}
