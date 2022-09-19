package com.week2Day1Backend.week2Day1Backend.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.week2Day1Backend.week2Day1Backend.Models.Book;
import com.week2Day1Backend.week2Day1Backend.Models.BookSummary;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jTemplate;

    private static final String SQL_GET_BOOKS = "select book_id, title from book2018 order by title asc limit ? offset ?;";
    private static final String SQL_GET_BOOK_BY_ID = "select * from book2018 where book_id = ?;";

    public List<BookSummary> getBooks(Integer limit, Integer offset){

        SqlRowSet rs = jTemplate.queryForRowSet(SQL_GET_BOOKS, limit, offset);

        List<BookSummary> summaries = new ArrayList<>();

        while (rs.next()){
            BookSummary summary = BookSummary.create(rs);
            summaries.add(summary);
        }

        return summaries;

    }

    public Optional<Book> getBookById(String bookId){

        SqlRowSet rs = jTemplate.queryForRowSet(SQL_GET_BOOK_BY_ID,bookId);

        if(rs.next()){return Optional.of(Book.create(rs));}

            return Optional.empty();

    }
    
}
