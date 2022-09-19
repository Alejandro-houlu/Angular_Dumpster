package com.week2Day1Backend.week2Day1Backend.Models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class BookSummary {

    private String bookId;
    private String title;


    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    } 

    public static BookSummary create(SqlRowSet rs){

        BookSummary bs = new BookSummary();
        bs.setBookId(rs.getString("book_id"));
        bs.setTitle(rs.getString(("title")));

        return bs;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add("bookId", bookId)
            .add("title", title)
            .build();
    }
    
}
