package com.ycat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.mapper.JokeMapper;
import com.ycat.mapper.UserMapper;
import com.ycat.pojo.CommentBean;
import com.ycat.pojo.JokeBean;
import com.ycat.pojo.JokeLikeBean;
import com.ycat.pojo.User;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.JokeService;
import com.ycat.utils.IDUtils;

@Service
public class JokeServiceIml implements JokeService {
	@Autowired
	JokeMapper jokeMapper;
	@Autowired
	UserMapper userMapper;

	public EuDataResult getJokeList(int page, int rows) {
		PageHelper.startPage(page, rows);

		List<JokeBean> list = jokeMapper.getJokeList();

		for (JokeBean bean : list) {
			User user = userMapper.selectUserById(bean.getJoke_user_id());
			List<JokeLikeBean> likeBeans = jokeMapper.selectJokeLikeById(bean.getJoke_id());
			List<CommentBean> commentBeans = jokeMapper.getJokeCommentById(bean.getJoke_id());
			if (user != null) {
				bean.setJoke_user_nick(user.getNickname());
				bean.setJoke_user_icon(user.getUser_icon());
			}
			if (likeBeans != null) {
				bean.setArticle_like_count(likeBeans.size());
			}
			if (commentBeans != null) {
				bean.setArticle_comment_count(commentBeans.size());
			}
		}

		EuDataResult euDataResult = new EuDataResult();

		System.out.println(list.size());

		euDataResult.setRows(list);
		int total = (int) new PageInfo<JokeBean>(list).getTotal();

		euDataResult.setTotal(total);

		return euDataResult;
	}

	public JokeBean addJoke(String title, String joke_user_id, String content) {
		JokeBean jokeBean = new JokeBean();

		jokeBean.setJoke_id(IDUtils.RandomId());
		jokeBean.setJoke_user_id(joke_user_id);
		jokeBean.setTitle(title);
		jokeBean.setContent(content);
		jokeBean.setPost_time(new Date());
		jokeBean.setArticle_comment_count(0);
		jokeBean.setArticle_like_count(0);
		jokeMapper.addJoke(jokeBean);

		return jokeBean;
	}

	public void thumbsJoke(String jokeId, String userId) {
		JokeLikeBean jokeLikeBean = new JokeLikeBean(jokeId, userId);
		jokeMapper.thumbsJoke(jokeLikeBean);
	}

	public List<JokeLikeBean> selectJokeLikeById(String jokeId) {
		List<JokeLikeBean> likeBeans = jokeMapper.selectJokeLikeById(jokeId);
		return likeBeans;
	}

	public CommentBean addComment(String jokeId, String userId, String details) {
		CommentBean commentBean = new CommentBean();
		commentBean.setComment_id(IDUtils.RandomId());
		commentBean.setJoke_id(jokeId);
		commentBean.setComment_user_id(userId);
		commentBean.setComment_details(details);
		commentBean.setComment_date(new Date());
		
		jokeMapper.addComment(commentBean);
		
		return commentBean;

	}

	public EuDataResult getJokeCommentById(int page, int rows, String jokeId) {
		PageHelper.startPage(page, rows);
		List<CommentBean> list = jokeMapper.getJokeCommentById(jokeId);

		for (CommentBean bean : list) {
			User user = userMapper.selectUserById(bean.getComment_user_id());
			if (user != null) {
				bean.setComment_nick(user.getNickname());
				bean.setComment_icon(user.getUser_icon());
			}
		}

		EuDataResult euDataResult = new EuDataResult();

		euDataResult.setRows(list);
		int total = (int) new PageInfo<CommentBean>(list).getTotal();

		euDataResult.setTotal(total);

		return euDataResult;
	}

}
