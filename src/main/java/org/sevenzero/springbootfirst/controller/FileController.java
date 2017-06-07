package org.sevenzero.springbootfirst.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileController {
	
	private static final Logger log = Logger.getLogger(FileController.class);
	
	@RequestMapping("/uploadindex")
	public String uploadIndex() {
		
		return "/file/upload";
	}
	
	@RequestMapping("uploadmult")
	@ResponseBody
	public String uploadMult(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		log.info("## " + files.size());
		
		int count = 0;
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				log.info("## 文件不为空 " + file.getOriginalFilename());
				String uploadDir = "/home/lb/temp/upload";
				File fileDir = new  File(uploadDir);
				if (!fileDir.exists()) {
					fileDir.mkdirs();
				}
				String path = uploadDir + File.separator + file.getOriginalFilename();
				
				try ( BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path)) ) {
					
					byte[] buffer = new byte[2048];
					int size = -1;
					while ( -1 != (size = bis.read(buffer, 0, 2048)) ) {
						bos.write(buffer, 0, size);
					}
					bos.flush();
					log.info("保存文件 " + path);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				count++;
			}
			else {
				log.info("## 文件为空");
			}
		}
		log.info("## count " + count);
		if (count == files.size()) {
			return "成功";
		}
		
		return "失败";
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			log.info("## 文件不为空 " + file.getOriginalFilename());
			String uploadDir = "/home/lb/temp/upload";
			File fileDir = new  File(uploadDir);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			String path = uploadDir + File.separator + file.getOriginalFilename();
			
			try ( BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path)) ) {
				
				byte[] buffer = new byte[2048];
				int size = -1;
				while ( -1 != (size = bis.read(buffer, 0, 2048)) ) {
					bos.write(buffer, 0, size);
				}
				bos.flush();
				log.info("保存文件 " + path);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			return "成功";
		}
		else {
			log.info("## 文件为空");
			
			return "失败";
		}
	}

}
