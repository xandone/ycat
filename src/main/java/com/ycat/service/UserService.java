package com.ycat.service;

import org.springframework.web.multipart.MultipartFile;

import com.ycat.pojo.User;
import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;

public interface UserService {

	EuDataResult getUserList(int page, int rows) throws Exception;

	DeleteResult deleteUser(String name) throws Exception;

	User selectUserById(String userId) throws Exception;

	User findUserByName(String userId) throws Exception;

	User addIcon(MultipartFile file, String userId) throws Exception;

}
