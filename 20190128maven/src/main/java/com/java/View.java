package com.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getView(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getView(request, response);
	}
	
	private void getView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String page = "/"+uri.substring(uri.lastIndexOf("/") + 1,  uri.length()); //마지막 시작점 찾기
		RequestDispatcher rd = request.getRequestDispatcher(page + ".jsp");
		System.out.println(page);
		rd.forward(request, response);
	}
}
