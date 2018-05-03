package com.ycat.service;


import org.springframework.web.multipart.MultipartFile;

import com.ycat.pojo.result.FileUpResult;

public interface ImageService {

	FileUpResult upfile(MultipartFile file) throws Exception;

}
