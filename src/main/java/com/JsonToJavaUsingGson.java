package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonToJavaUsingGson {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("sample.json"));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line= br.readLine()) != null){
			sb.append(line);
		}
		
		System.out.println("Original Json "+sb.toString());
		
		JsonObject gsonObj = new Gson().fromJson(sb.toString(), JsonObject.class);
		
		String name = gsonObj.getAsJsonObject("empInfo").get("name").getAsString();
		String position = gsonObj.getAsJsonObject("empInfo").get("position").getAsString();
		String age = gsonObj.getAsJsonObject("empInfo").get("age").getAsString();
		
		System.out.println("emp name: "+name);
		System.out.println("emp position: "+position);
		System.out.println("emp age: "+age);
		
		JsonArray jsonArr = gsonObj.getAsJsonArray("skills");
		
		for (int i = 0; i < jsonArr.size(); i++) {
			
			String programming = jsonArr.get(i).getAsJsonObject().get("programming").getAsString();
			String scripting = jsonArr.get(i).getAsJsonObject().get("scripting").getAsString();
			String ml = jsonArr.get(i).getAsJsonObject().get("ml").getAsString();
			System.out.println("programming: "+programming);
			System.out.println("scripting: "+scripting);
			System.out.println("ml: "+ml);
		}
		
	}

}
