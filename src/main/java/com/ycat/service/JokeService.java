package com.ycat.service;

import com.ycat.pojo.JokeBean;
import com.ycat.pojo.result.EuDataResult;

public interface JokeService {

	EuDataResult getJokeList(int page, int rows);

	JokeBean addJoke(String title, String joke_user_id, String content);
}
