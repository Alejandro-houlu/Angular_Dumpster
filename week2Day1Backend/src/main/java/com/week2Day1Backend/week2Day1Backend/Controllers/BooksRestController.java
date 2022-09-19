package com.week2Day1Backend.week2Day1Backend.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.week2Day1Backend.week2Day1Backend.Models.Book;
import com.week2Day1Backend.week2Day1Backend.Models.BookResponse;
import com.week2Day1Backend.week2Day1Backend.Models.BookSummary;
import com.week2Day1Backend.week2Day1Backend.Services.BookService;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BooksRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<String> getBooks(@RequestParam(defaultValue = "20") Integer limit, 
    @RequestParam(defaultValue = "0") Integer offset){

        List<BookSummary> bSummaries = bookService.search(limit, offset);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for(BookSummary summary: bSummaries){
            arrBuilder.add(summary.toJson());
        }
        

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping("/bookDetails/{bookId}")
    public ResponseEntity<String> getBookById(@PathVariable String bookId){

        Optional<Book> opt = bookService.getBookById(bookId);

        if(opt.isEmpty()){
            BookResponse bookResponse = new BookResponse();
            bookResponse.setStatus(404);
            bookResponse.setMessage("Book %s not found".formatted(bookId));

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookResponse.toJson().toString());
        }

        Book book = opt.get();

        return ResponseEntity.ok(book.toJson().toString());
    }

    
}
