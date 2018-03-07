package com.ycat.pojo.result;

public class RegistResult {
	// 不加成员变量报错
	// No serializer found for class comand no properties discovered to create
	// BeanSerializer
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
