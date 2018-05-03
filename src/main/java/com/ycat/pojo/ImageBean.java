package com.ycat.pojo;

import java.util.Date;

public class ImageBean {

	private String userId;
	private String imgId;
	private Date upTime;
	private String imgUrl;
	private String pageViews;// 浏览量

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPageViews() {
		return pageViews;
	}

	public void setPageViews(String pageViews) {
		this.pageViews = pageViews;
	}

}
