package com.ycat.service;

import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;

public interface UserService {

	EuDataResult getUserList(int page, int rows);
	
	DeleteResult deleteUser(String name) throws Exception;

}
