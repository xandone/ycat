package com.ycat.mapper;

import java.util.List;

import com.ycat.pojo.ImageBean;

public interface ImageMapper {
	List<ImageBean> getImageList();

	void addImage(ImageBean imageBean);

	void deteImage(String imgId);

}
