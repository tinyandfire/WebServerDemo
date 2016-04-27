package com.yangjw.server.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
/**
 * @author yangjw
 * 文件上传
 * 此类主要给android开发人员做文件上传测试用。
 * androidxx.cn
 *
 */
public class UploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		ServletFileUpload servletFileUpload = new ServletFileUpload();
		try {
			FileItemIterator fileItemIterator = servletFileUpload.getItemIterator(req);
			while(fileItemIterator.hasNext()) {
				FileItemStream fis = fileItemIterator.next();
				if (fis.isFormField()) {
					String fieldName = fis.getFieldName();
					InputStream is = fis.openStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String str = null;
					while((str=br.readLine()) != null) {
						System.out.println(fieldName +"="+ str);
					}
					is.close();
					br.close();
				} else {
					System.out.println("---------------------------------");
					String fileName = fis.getName();
					InputStream is = fis.openStream();
					
					File dir = new File("C:\\download\\");
					if (!dir.exists()) {
						dir.mkdir();
					}
					FileOutputStream fos = new FileOutputStream(new File("C:\\download\\"+fileName));
					int len=0;
					byte[] buffer = new byte[1024];
					while((len=is.read(buffer)) != -1) {
						fos.write(buffer, 0, len);
						fos.flush();
					}
					is.close();
					fos.close();
				}
				
			}
			
			resp.getWriter().write("success");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write("failure");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
