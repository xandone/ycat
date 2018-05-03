package com.ycat.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycat.config.Config;
import com.ycat.mapper.ImageMapper;
import com.ycat.pojo.ImageBean;
import com.ycat.pojo.result.EuDataResult;
import com.ycat.pojo.result.FileUpResult;
import com.ycat.service.ImageService;
import com.ycat.utils.FtpClientUtils;
import com.ycat.utils.IDUtils;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageMapper imageMapper;

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
			String imgUrl = Config.FTP_HOST_PATH + newName;
			fileUpResult = new FileUpResult(imgUrl);
			System.out.println(imgUrl);
		}

		a.closeFTP(ftp);

		return fileUpResult;
	}

	@Override
	public ImageBean upfileByUser(MultipartFile file, String userId) throws Exception {
		ImageBean imageBean = null;

		String filename = file.getOriginalFilename(); // 获得原始的文件名
		String newName = IDUtils.RandomId() + filename.substring(filename.lastIndexOf("."));

		InputStream input = file.getInputStream();
		FtpClientUtils a = new FtpClientUtils();
		FTPClient ftp = a.getConnectionFTP("192.168.117.128", 21, "ftpuser", "@@22xiao");
		boolean success = a.uploadFile(ftp, Config.FTP_IMAGE_PATH, newName, input);

		if (success) {
			String imgUrl = Config.FTP_HOST_PATH + newName;
			imageBean = new ImageBean();
			imageBean.setImgId(IDUtils.RandomId());
			imageBean.setImgUrl(imgUrl);
			imageBean.setUserId(userId);
			imageBean.setPageViews("0");
			imageBean.setUpTime(new Date());
			imageMapper.addImage(imageBean);

			System.out.println(imgUrl);
		}

		a.closeFTP(ftp);

		return imageBean;
	}

	@Override
	public EuDataResult getImageList(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<ImageBean> list = imageMapper.getImageList();
		EuDataResult euDataResult = new EuDataResult();
		euDataResult.setRows(list);
		int total = (int) new PageInfo<ImageBean>(list).getTotal();
		euDataResult.setTotal(total);

		return euDataResult;
	}

}
