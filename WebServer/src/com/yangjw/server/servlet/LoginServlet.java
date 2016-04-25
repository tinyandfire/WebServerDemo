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
	 * 后台服务器的Post方法
	 * androidxx.cn
	 * created by yangjw at 2016.4.24
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========androidxx.cn===========");
		//-------------------后台接受Form表单数据的方式----------------------
		String userName = req.getParameter("username");
		System.out.println("userName=" + userName);
		//--------------------后台接收Json格式数据的方式---------------------
		InputStream is = req.getInputStream();
		int len=0;
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((len = is.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		is.close();
		System.out.println(new String(baos.toByteArray()));
		//处理完成之后的挑传
		resp.getWriter().write("success");
//		resp.sendRedirect("success.jsp");
		return;
	}
	
//	private void multiPart(HttpServletRequest req) {
//		 ms = 
//	}
	
}
