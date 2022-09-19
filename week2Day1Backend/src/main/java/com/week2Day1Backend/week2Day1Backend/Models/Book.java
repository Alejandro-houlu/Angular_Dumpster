package com.week2Day1Backend.week2Day1Backend.Models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Book {

    private String bookId;
    private String title;
    private String authors;
    private String description;
    private String rating;
    private String imageUrl;

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
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static Book create(SqlRowSet rs){

        Book book = new Book();
        book.setBookId(rs.getString("book_id"));
        book.setTitle(rs.getString(("title")));
        book.setAuthors(rs.getString("authors"));
        book.setDescription(rs.getString("description"));
        book.setRating(rs.getString("rating"));
        book.setImageUrl(rs.getString("image_url"));

        return book;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add("bookId", bookId)
            .add("title", title)
            .add("authors",authors)
            .add("description",description)
            .add("rating",rating)
            .add("imageUrl",imageUrl)
            .build();
    }
    
}
