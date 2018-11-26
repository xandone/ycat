package com.ycat.pojo;

import java.util.Date;

public class HeadArticleBean {
	private String userId;
	private String articelId;
	private String imgUrl;
	private String title;
	private String articleUrl;
	private int pageViews;
	private Date upTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getArticelId() {
		return articelId;
	}

	public void setArticelId(String articelId) {
		this.articelId = articelId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public int getPageViews() {
		return pageViews;
	}

	public void setPageViews(int pageViews) {
		this.pageViews = pageViews;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

}
