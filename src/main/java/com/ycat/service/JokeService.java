package com.ycat.service;

import com.ycat.pojo.result.EuDataResult;

public interface JokeService {
	
	EuDataResult getJokeList(int page, int rows);


}
