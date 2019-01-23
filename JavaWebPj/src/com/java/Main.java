package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Main")
public class Main extends HttpServlet {	
	
	private Mybatis m;
	public Main() {
		m = new Mybatis();
	}
	
	//Request 요청 부분
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//오버라이드 (재구성)
		System.out.println("doGet");
		m.main(response);
		//response.setCharacterEncoding("utf-8");	//전송되는 데이터가 UTF-8
		//response.setContentType("text/html;charset=UTF-8"); //전송되는 데이터가 
		//PrintWriter pw = response.getWriter();
		//pw.write(result);
		//response.getWriter().append("Served at: ").append(request.getContextPath());	//respone의 내용 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		m.main(response);
	}
	
}
