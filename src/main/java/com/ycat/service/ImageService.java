package com.ycat.service;

import org.springframework.web.multipart.MultipartFile;

import com.ycat.pojo.ImageBean;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.pojo.result.FileUpResult;

public interface ImageService {

	FileUpResult upfile(MultipartFile file) throws Exception;

	ImageBean upfileByUser(MultipartFile file, String userId) throws Exception;

	EuDataResult getImageList(int page, int rows) throws Exception;
	
}
