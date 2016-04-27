package com.yangjw.server.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.MultipartStream;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("----------------");
		
		resp.sendRedirect("success.jsp");
		return;
	}
	/**
	 * 
	 * androidxx.cn
	 * created by yangjw at 2016.4.24
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========androidxx.cn===========");
		
		String userName = req.getParameter("username");
		System.out.println("userName=" + userName);
		
		InputStream is = req.getInputStream();
		int len=0;
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((len = is.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		is.close();
		System.out.println(new String(baos.toByteArray()));
		
		resp.getWriter().write("success");

		return;
	}
	
	
}
