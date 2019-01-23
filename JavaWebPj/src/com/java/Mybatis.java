package com.java;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Mybatis {

	public void main(HttpServletResponse response) {
		System.out.println("Mybatis Start!");
		response.setCharacterEncoding("utf-8");	//전송되는 데이터가 UTF-8
		response.setContentType("text/html;charset=UTF-8"); //전송되는 데이터가 
		//String result = "";
		try 
		{
			PrintWriter pw = response.getWriter();
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession session = sqlSessionFactory.openSession(); //connection정보 Open 과 같다.
			List<HashMap<String,Object>> list = null;
			try {
			  list = session.selectList("TestMapper.select");
			} finally {
			  session.close();
			}
			
			
			/*
			for(int i = 0; i<list.size(); i++) {
				//HashMap = HashTable 순서가없는것이 동일하다.
				HashMap<String,Object>map = (HashMap<String,Object>)list.get(i);	
				Set set = map.keySet();
				Iterator it = set.iterator();
				//while 문은 boolean이 와야하므로 return 값이 boolean 인 hasNext() 사용
				while(it.hasNext()) {
					String key = it.next().toString();
					map.get(key); // = value 를 의미 	
					pw.append(key + " : " + map.get(key)+"\t");	//append 사용하여 추가한다.
					//result += key + " : " + map.get(key)+"\t";
					//System.out.print(key + " : " + map.get(key));
				}
				//System.out.println("");
				//result += "<br>";
				pw.append("<br>");
			}
			*/
			
			//pw.write(result);
			
			/// JSON 파일만들기! :: 데이터로 관리 java는 별도의 라이브러리가 필요하다.
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("data", list);
			JSONObject jo = new JSONObject();
			jo = JSONObject.fromObject(JSONSerializer.toJSON(map));  //리스트 객체를 JSON 형식으로 바꾼다.(=> 키값을 지정해주어야함)
			
			pw.write(jo.toString());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
