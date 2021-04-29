package com.inminhouse.study.spring.ch08;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	
	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file = (File) model.get("downloadFile");
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		
		String useragent = request.getHeader("User-Agent");
		String fileName = useragent.indexOf("MSIE") > -1 ? 
			URLEncoder.encode(file.getName(), "utf-8") :
			new String(file.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream(); // out은 종료되면 안됨
		try(FileInputStream fis = new FileInputStream(file)) {
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		out.flush();
	}

}
