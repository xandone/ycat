package com.ycat.pojo;

import java.util.Date;

public class CommentBean {
	private String comment_id;
	private String joke_id;
	private String comment_user_id;
	private String comment_details;
	private Date comment_date;
	private String comment_nick;
	private String comment_icon;
	
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getJoke_id() {
		return joke_id;
	}
	public void setJoke_id(String joke_id) {
		this.joke_id = joke_id;
	}
	public String getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(String comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public String getComment_details() {
		return comment_details;
	}
	public void setComment_details(String comment_details) {
		this.comment_details = comment_details;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getComment_nick() {
		return comment_nick;
	}
	public void setComment_nick(String comment_nick) {
		this.comment_nick = comment_nick;
	}
	public String getComment_icon() {
		return comment_icon;
	}
	public void setComment_icon(String comment_icon) {
		this.comment_icon = comment_icon;
	}
	
	

}
