package com.ycat.pojo;

import java.util.Date;

public class JokeBean {
	private String joke_id;
	private String joke_user_id;
	private String title;
	private String content;
	private Date post_time;
	private int article_like_count;
	private int article_comment_count;

	public String getJoke_id() {
		return joke_id;
	}

	public void setJoke_id(String joke_id) {
		this.joke_id = joke_id;
	}

	public String getJoke_user_id() {
		return joke_user_id;
	}

	public void setJoke_user_id(String joke_user_id) {
		this.joke_user_id = joke_user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPost_time() {
		return post_time;
	}

	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}

	public int getArticle_like_count() {
		return article_like_count;
	}

	public void setArticle_like_count(int article_like_count) {
		this.article_like_count = article_like_count;
	}

	public int getArticle_comment_count() {
		return article_comment_count;
	}

	public void setArticle_comment_count(int article_comment_count) {
		this.article_comment_count = article_comment_count;
	}

}
