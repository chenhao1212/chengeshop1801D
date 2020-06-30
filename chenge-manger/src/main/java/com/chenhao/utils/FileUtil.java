package com.chenhao.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@PropertySource("classpath:hgshop.properties")
public class FileUtil {
	
	@Value("${win.pic.savepath}")
	private String path;
	//根据上传时间创建文件夹，分开存放文件
	
	private String pathSplit="/";
	
	public String upPath(MultipartFile file) {
		//根据时间计算存放路径
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(new Date());
		//要存放文件的路径
		File filePath= new File(path+pathSplit+dateString);
		//如果路径不存在则创建路径
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		System.out.println("-----------------------"+path);
		//获取源文件名
		String oldName = file.getOriginalFilename();
		//获取扩展名
		String suffixName = oldName.substring(oldName.lastIndexOf("."));
		//创建一个新名字
		String newName = UUID.randomUUID().toString()+suffixName;
		//创建当前绝对路径的文件
		File imgFile= new File(path+pathSplit+dateString+pathSplit+newName);
		//把旧文件复制到新文件里面
		try {
			file.transferTo(imgFile);
			return dateString+pathSplit+newName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
