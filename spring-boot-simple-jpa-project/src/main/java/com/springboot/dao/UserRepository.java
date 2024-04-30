package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.dto.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String str);
	
	@Query("select u from User u")
	public List<User> allData();
	
	@Query(value="select * from user",  nativeQuery = true)
	public List<User> allDataNativ();
}
