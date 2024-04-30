package com.springboot.springbootjpawithrestproject.dao;

import org.springframework.data.repository.CrudRepository;
import com.springboot.springbootjpawithrestproject.dto.Book;

public interface BookRepository extends CrudRepository< Book, Integer > {

}
