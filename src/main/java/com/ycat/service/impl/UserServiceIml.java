package com.ycat.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.config.Config;
import com.ycat.mapper.UserMapper;
import com.ycat.pojo.User;
import com.ycat.pojo.result.DeleteResult;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.service.UserService;
import com.ycat.utils.FtpClientUtils;
import com.ycat.utils.IDUtils;

@Service
public class UserServiceIml implements UserService {
	@Autowired
	UserMapper userMapper;

	public EuDataResult getUserList(int page, int rows) {
		// TODO Auto-generated method stub

		PageHelper.startPage(page, rows);

		List<User> list = userMapper.getUserList();

		EuDataResult euDataResult = new EuDataResult();
		euDataResult.setRows(list);
		int total = (int) new PageInfo<User>(list).getTotal();
		euDataResult.setTotal(total);
		euDataResult.setMsg("成功");
		euDataResult.setCode(200);

		return euDataResult;

	}

	public DeleteResult deleteUser(String name) {
		userMapper.deleteUser(name);
		DeleteResult deleteResult = new DeleteResult();
		return deleteResult;
	}

	public User selectUserById(String userId) {
		User user = userMapper.selectUserById(userId);
		return user;
	}

	public User findUserByName(String userName) {
		User user = userMapper.findUserByName(userName);
		return user;
	}

	@Override
	public User addIcon(MultipartFile file, String userId) throws Exception {
		User user = userMapper.selectUserById(userId);
		if (user == null) {
			return null;
		}

		String filename = file.getOriginalFilename(); // 获得原始的文件名
		String newName = IDUtils.RandomId() + filename.substring(filename.lastIndexOf("."));

		InputStream input = file.getInputStream();
		FtpClientUtils a = new FtpClientUtils();
		FTPClient ftp = a.getConnectionFTP(Config.FTP_IP, 21, "ftpuser", "@@22xiao");
		boolean success = a.uploadFile(ftp, Config.FTP_IMAGE_PATH, newName, input);

		a.closeFTP(ftp);

		if (!success) {
			return null;
		}
		String newIconUrl = Config.FTP_HOST_PATH + newName;
		user.setUser_icon(newIconUrl);
		Map<String, String> map = new HashMap<>();
		map.put("user_id", userId);
		map.put("user_icon", newIconUrl);
		userMapper.changeUserIcon(map);

		return user;

	}

}
