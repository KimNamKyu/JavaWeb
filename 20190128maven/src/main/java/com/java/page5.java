package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class page5 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("usr", request.getParameter("usr"));
		paramMap.put("pwd", request.getParameter("pwd"));
		login(request, response, paramMap);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		HashMap<String,Object> paramMap = new HashMap<>();
		Enumeration<String> pns = request.getParameterNames(); //배열 형식으로 담김
		
		while(pns.hasMoreElements()) {
			String paramName = pns.nextElement();
			System.out.println(paramName + " : " + request.getParameter(paramName));
			paramMap.put(paramName, request.getParameter(paramName));
		}
		System.out.println(paramMap);
		login(request, response, paramMap);
	}
	
	//공통모듈
	private void login(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> paramMap) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		if(paramMap.get("usr") == null || ("").equals(paramMap.get("usr"))) {
			pw.write("사용자 정보를 입력해주세요.");
			return;
		}
		
		if(paramMap.get("pwd") == null || ("").equals(paramMap.get("pwd"))) {
			pw.write("패스워드를 입력해주세요 ");
			return;
		}
						
		if("admin".equals(paramMap.get("usr"))) {
			
			if("1234".equals(paramMap.get("pwd"))) {
				pw.write(paramMap.get("usr") + "님 로그인이 성공하였습니다. 환영합니다");
			}else {
				pw.write("비밀번호가 틀립니다");
			}
		}else {
			pw.write("사용자가 아닙니다");
		}
	}

}
