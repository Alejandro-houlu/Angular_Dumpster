package com.fileuploadangular.fileUploadBackend.Repositories;

import java.lang.StackWalker.Option;
import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.fileuploadangular.fileUploadBackend.Models.Post;

@Repository
public class uploadRepo {

    @Autowired
    JdbcTemplate jTemplate;

    private static final String SQL_INSERT_BLOB = "insert into post(title, pic, media_type) values(?,?,?);";
    private static final String SQL_GET_UPLOAD = "select * from post where post_id = ?;";

    public void insertPost(MultipartFile myFile, String title){
        try {
            Integer updated = jTemplate.update(SQL_INSERT_BLOB, title,myFile.getInputStream(), myFile.getContentType());
            System.out.println("updated: " + updated);
        } catch (Exception e) {
            System.out.println();
        }
    }

    public Optional<Post> getPost(Integer postId){
        return jTemplate.query(SQL_GET_UPLOAD, 
        (ResultSet rs) ->{
            if(!rs.next())
            return Optional.empty();
                return Optional.of(Post.create(rs));
        },postId);
    }


    
}
