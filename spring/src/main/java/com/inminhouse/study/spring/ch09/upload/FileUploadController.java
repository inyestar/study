package com.inminhouse.study.spring.ch09.upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String view() {
		return "upload/index";
	}
	
	@RequestMapping(value="/upload/file", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("f") MultipartFile file, @RequestParam("title") String title, Model model) throws IOException {
		
		if(!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			File temp = new File(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
			FileCopyUtils.copy(bytes, temp);
			model.addAttribute("title", title);
			model.addAttribute("name", file.getOriginalFilename());
			model.addAttribute("path", temp.getAbsolutePath());
			return "upload/result";
		}
		return "upload/404";
	}
}
