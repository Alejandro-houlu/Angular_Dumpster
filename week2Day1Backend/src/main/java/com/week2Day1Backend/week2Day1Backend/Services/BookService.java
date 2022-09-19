package com.week2Day1Backend.week2Day1Backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.week2Day1Backend.week2Day1Backend.Models.Book;
import com.week2Day1Backend.week2Day1Backend.Models.BookSummary;
import com.week2Day1Backend.week2Day1Backend.Repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    @Transactional
    public List<BookSummary> search(Integer limit, Integer offset){

        return bookRepo.getBooks(limit, offset);
    }

    @Transactional
    public Optional<Book> getBookById(String bookId){
        
        return bookRepo.getBookById(bookId);
    }
    
}
