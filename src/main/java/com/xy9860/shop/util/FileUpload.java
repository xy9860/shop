package com.xy9860.shop.util;

import com.xy9860.shop.model.FileImage;

public interface FileUpload {

	//实现文件上传的功能,返回上传后新的文件名称
	String uploadFile(FileImage fileImage);

}