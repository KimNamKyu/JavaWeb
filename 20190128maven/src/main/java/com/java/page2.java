package com.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class page2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String uri = request.getRequestURI();
		System.out.println(uri);
		System.out.println(uri.substring("/20190128maven/page2".length(), uri.length()));	//끝에 String
		System.out.println(uri.substring(uri.indexOf("/20190128maven/page2"),  uri.length())); //앞의 시작부분 String
		System.out.println(uri.substring(uri.lastIndexOf("/") + 1,  uri.length())); //마지막 시작점 찾기
		*/
		//response.sendsendRedirect(page); // page1.jsp >> //dns:port/path/page1.jsp
		//RequestDispatcher rd = request.getRequestDispatcher(page);
		//rd.forward(request.response); // page.jsp >> http://dns:port/path/Page2/page1.jsp
										// page.jsp >> http://dns:port/path/page1.jsp
		getView(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getView(request,response);
	}
	
	//공통메소드 Dispatcher이 중복되므로
	private void getView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String page = "/"+ uri.substring(uri.lastIndexOf("/") + 1,  uri.length()); //마지막 시작점 찾기
		RequestDispatcher rd = request.getRequestDispatcher(page + ".jsp");
		System.out.println(page);
		rd.forward(request, response);
	}
}
