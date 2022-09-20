package com.fileuploadangular.fileUploadBackend.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

public class Post {

    private Integer postId;
    private String title;
    private String mediaType;
    private byte[] content;

    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMediaType() {
        return mediaType;
    }
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public byte[] getContent() {
        return content;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }

    public static Post create(ResultSet rs)throws SQLException{
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setTitle(rs.getString("title"));
        post.setMediaType(rs.getString("media_type"));
        post.setContent(rs.getBytes("pic"));

        return post;
    }

    
    
}
