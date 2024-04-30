package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Student student = context.getBean(Student.class);
		Student student1 = context.getBean(Student.class);
		System.out.println("Hello Shivshankar Mishra.....");
		student.setName("Ram");
		student.setEmail("ram@mail");
		student.setPhone(108108108);
		System.out.println(student);
		student.show();
		student1.setName("Shyam");
		student1.setEmail("shyam@mail");
		student1.setPhone(111111111);
		System.out.println(student1);
		student1.show();
	}

}
