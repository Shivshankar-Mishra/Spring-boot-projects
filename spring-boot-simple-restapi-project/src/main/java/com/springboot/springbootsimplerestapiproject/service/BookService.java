package com.springboot.springbootsimplerestapiproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.springbootsimplerestapiproject.dto.Book;

@Component
public class BookService {

    public static List<Book> list = new ArrayList<Book>();
    // Book book = null;

    static {
        list.add(new Book(1, "Math", "Manohar"));
        list.add(new Book(2, "Java", "J Goshling"));
        list.add(new Book(3, "Python", "Gan V. Rossom"));
    }

    // display one data
    public Book getBookById(int id) {
        Book book = null;
        try{
            book = list.get(id - 1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    // Display all book data
    public List<Book> getBookList() {
        return list;
    }

    // Add a book to the list
    public Book addBook(Book book) {
        if (list.add(book))
            return book;
        return null;
    }

    // Update a book by there bookId
    public void updateBook(Book book, int bookId) {
        list = list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

    // Delete a book by its id
    public void deleteBook(int bookId) {
        list.stream().filter(b -> {
            if (b.getId() != bookId) {
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());
    }

}
