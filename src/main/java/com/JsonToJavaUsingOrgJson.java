package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToJavaUsingOrgJson{
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sample.json"));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!= null) {
			sb.append(line);
		}
		
		System.out.println("original json "+sb.toString());
		
		JSONObject jsonObject = new JSONObject(sb.toString());
		
		String name = jsonObject.getJSONObject("empInfo").getString("name");
		String position = jsonObject.getJSONObject("empInfo").getString("position");
		String age =  jsonObject.getJSONObject("empInfo").getString("age");
		
		
		System.out.println("employee name: "+name);
		System.out.println("employee position: "+position);
		System.out.println("employee age: "+age);
		
		JSONArray jsonArr = jsonObject.getJSONArray("skills");
		
		for (int i = 0; i < jsonArr.length(); i++) {
			String programming = jsonArr.getJSONObject(i).getString("programming");
			String scripting = jsonArr.getJSONObject(i).getString("scripting");
			String ml = jsonArr.getJSONObject(i).getString("ml");
			
			System.out.println("Programming: "+programming);
			System.out.println("Scripting: "+scripting);
			System.out.println("ML: "+ml);
		}
		
	}

	

}
