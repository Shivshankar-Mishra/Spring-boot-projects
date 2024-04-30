package com.springboot.springbootsimplerestapiproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootsimplerestapiproject.dto.Book;
import com.springboot.springbootsimplerestapiproject.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ApiController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "This is index page";
    }

    // Displaying the static book
    @GetMapping("/book")
    public Book getBook() {
        Book book = new Book(1, "HTML", "Tim Burner Lee");
        return book;
    }

    // Display one book by the bookId
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") int bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return ResponseEntity.ok().body(book);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Display All books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> list = bookService.getBookList();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    // Adding one book in the list
    @PostMapping("/book")
    public ResponseEntity<Book> postBook(@RequestBody Book book) {
        Book b = null;
        try{
            b = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }

    // upading a book data
    @PutMapping("/book/{bookId}")
    public void updateBookById(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        bookService.updateBook(book, bookId);
    }

    // Delete a book from the list
    @DeleteMapping("/book/{bookId}")
    public void deleteBookById(@PathVariable("bookId") int id) {
        bookService.deleteBook(id);
    }

}
