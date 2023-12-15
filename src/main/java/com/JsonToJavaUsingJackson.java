package com;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaUsingJackson {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			EmployeeParent empParent = objectMapper.readValue(new File("sample.json"), EmployeeParent.class);
			
			System.out.println("employee name: "+empParent.getEmpInfo().getName());
			System.out.println("employee position: "+empParent.getEmpInfo().getPosition());
			System.out.println("employee salary: "+empParent.getEmpInfo().getSalary());
			System.out.println("employee age: "+empParent.getEmpInfo().getAge());
			
			for (Skills skills : empParent.getSkills()) {
				System.out.println("Programming: "+skills.getProgramming());
				System.out.println("Scripting: "+skills.getScripting());
				System.out.println("ML: "+skills.getMl());
			}
			
		} catch (Exception e) {
		}
	}
}
