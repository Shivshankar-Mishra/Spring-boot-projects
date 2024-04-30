package com.springboot.springbootjpawithrestproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootjpawithrestproject.dao.BookRepository;
import com.springboot.springbootjpawithrestproject.dto.Book;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    // Add One book in to the database
    @PostMapping("/book")
    public Book postOneBook(@RequestBody Book book) {
        System.out.println(book);
        return bookRepository.save(book);
    }
    

    // Display One Book by there id
    @GetMapping("/book/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        Optional<Book> optional = bookRepository.findById(bookId);
        return optional.get();
    }

    // Display All books
    @GetMapping("/books")
    public List<Book> getAllBooks(){
       return (List<Book>)bookRepository.findAll();
    }

    // Update book data by there id
    @PutMapping("/book/{id}")
    public Book putMethodName(@PathVariable("id") int id, @RequestBody Book book) {
        Book b = getBookById(id);
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        return bookRepository.save(b);        
        
    }

    //  Delete book data by there id
    @DeleteMapping("/book/{bookId}")
    @ResponseBody
    public String deleteBookById(@PathVariable("bookId") int bookId) {
        bookRepository.delete(getBookById(bookId));
        return "Book deleted...";
    }
    
}
