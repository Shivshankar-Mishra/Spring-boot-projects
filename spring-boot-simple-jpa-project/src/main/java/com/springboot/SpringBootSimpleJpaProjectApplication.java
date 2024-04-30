package com.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.dao.UserRepository;
import com.springboot.dto.User;

@SpringBootApplication
public class SpringBootSimpleJpaProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootSimpleJpaProjectApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);
//		User u1 = new User();
//		u1.setName("Shankar");
//		u1.setEmail("sankar@mail.com");
//		u1.setPhone(555555555);
//		User u2 = new User();
//		u2.setName("Kumar");
//		u2.setEmail("kumar@mail.com");
//		u2.setPhone(666666666);
//		List<User> users = List.of(u1,u2);
//		System.out.println(u);
//		User user = repository.save(u);
//		Iterable<User> itr = repository.saveAll(users);
//		itr.forEach(u->System.out.println(u));
		Optional<User> optional = repository.findById(1);
		User user = optional.get();
		System.out.println(user);
		System.out.println("--------------------------------------------------");
		Iterable<User> itr = repository.findAll();
		itr.forEach(u->System.out.println(u));
		System.out.println("--------------------------------------------------");
		User user1 = repository.findByName("Shankar");
		System.out.println(user1);
		System.out.println("---------------------------------------------------");
		List<User> users = repository.allDataNativ();
		users.forEach(us->System.out.println(us));
		
	}

}
