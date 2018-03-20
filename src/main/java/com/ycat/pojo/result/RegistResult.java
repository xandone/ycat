package com.ycat.pojo.result;

public class RegistResult {
	// 不加成员变量报错
	// No serializer found for class comand no properties discovered to create
	// BeanSerializer
	private String nickName;
	private String userId;



	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
