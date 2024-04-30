package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
	private String name;
	private String email;
	private long phone;
	public Student() {
		super();
		System.out.println("Object created");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void show() {
		System.out.println("Object is being used");
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	

}
