package com.ycat.service;

import com.ycat.pojo.result.EuDataResult;

public interface UserService {
	
	EuDataResult getUserList(int page,int rows);

}
