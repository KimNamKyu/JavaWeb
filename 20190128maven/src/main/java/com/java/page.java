package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class page extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoGet");
		// 1. sendRedirect
		//response.sendRedirect("page.jsp");
		
		String key = request.getParameter("key");
		System.out.println(key);
		
		// 주소는 없고 서블릿을 거쳣다가 Jsp로 갓을시 존재하는 데이터
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		request.setAttribute("data", list);
				
		// 2. 전달 forward(객체 만들기) RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("page.jsp");	//화면처리시 도움을 주는 객체
		
		//Servlet 에서 request와 response 를 전달한다 해당 jsp파일에. / response에 값을 넣어 전달 가능!
		rd.forward(request, response);	//다른 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = new ArrayList();
		request.setAttribute("data", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("page.jsp");
		rd.forward(request, response);
	}

	

	
}
