package com.ycat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ycat.pojo.ImageBean;
import com.ycat.pojo.result.BaseResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.ImageService;

@Controller
public class ImageController extends BaseController {

	@Autowired
	ImageService imageService;

	@RequestMapping("/imagelist")
	@ResponseBody
	public EuDataResult getJokeList(Integer page, Integer rows) {
		EuDataResult euDataResult = imageService.getImageList(page, rows);
		return euDataResult;
	}

	@RequestMapping("upload.do")
	public BaseResult upfileByUser(@RequestParam(value = "file") MultipartFile file, String userId) throws Exception {
		
		if (userId == null || userId == "") {
			userId = "123456";
		}

		System.out.println(userId);

		if (file == null) {
			System.out.println("上传文件为空");
			return null;
		}
		BaseResult baseResult = new BaseResult();
		List<ImageBean> dataList = new ArrayList<>();
		ImageBean imageBean = imageService.upfileByUser(file, userId);

		if (imageBean != null) {
			baseResult.setCode(SUCCESS_CODE);
			dataList.add(imageBean);
			baseResult.setDataList(dataList);
		} else {
			baseResult.setCode(ERROR_CODE);
		}

		return baseResult;

	}

}
