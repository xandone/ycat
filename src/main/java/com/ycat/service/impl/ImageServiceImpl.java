package com.ycat.service.impl;

import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ycat.config.Config;
import com.ycat.pojo.result.FileUpResult;
import com.ycat.service.ImageService;
import com.ycat.utils.FtpClientUtils;
import com.ycat.utils.IDUtils;

@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public FileUpResult upfile(MultipartFile file) throws Exception {
		FileUpResult fileUpResult = null;

		String filename = file.getOriginalFilename(); // 获得原始的文件名
		String newName = IDUtils.RandomId() + filename.substring(filename.lastIndexOf("."));

		InputStream input = file.getInputStream();
		FtpClientUtils a = new FtpClientUtils();
		FTPClient ftp = a.getConnectionFTP("192.168.117.128", 21, "ftpuser", "@@22xiao");
		boolean success = a.uploadFile(ftp, Config.FTP_IMAGE_PATH, newName, input);

		if (success) {
			String imgUrl = Config.FTP_HOST + newName;
			fileUpResult = new FileUpResult(imgUrl);
			System.out.println(imgUrl);
		}
		
		a.closeFTP(ftp);
		
		return fileUpResult;
	}

}
