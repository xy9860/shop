package com.xy9860.shop.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xy9860.shop.model.FileImage;

/**
 * 用来实现文件上传的业务逻辑
 * */
@Component("fileUpload")//组件 代表工具类
public class FileUploadImpl implements FileUpload {
	@Value("#{prop.imagePath}")
	private String imagePath;
	
	//通过文件名获得扩展名
	private String getFileExt(String fileName){
		if (fileName!=null) {
			return FilenameUtils.getExtension(fileName);
		}
		return null;
	}
	
	//生成UUID随机数 作为新的文件名
	private String newFileName(String fileName){
		String ext=getFileExt(fileName);
		return UUID.randomUUID()+"."+ext;
	}
	
	//实现文件上传的功能,返回上传后新的文件名称
	/* (non-Javadoc)
	 * @see com.xy9860.shop.util.FileUpload#uploadFile(com.xy9860.shop.model.FileImage)
	 */
	public String uploadFile(FileImage fileImage) {
		//获取真实的pic
		String pic =newFileName(fileImage.getFilename());
		//实现文件上传的逻辑
		try {
			FileUtil.copyFile(fileImage.getFile(),new File(imagePath,pic));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			fileImage.getFile().delete();//删除temp文件
		}
		return pic;
	}
}
