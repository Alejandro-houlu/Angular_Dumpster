package com.fileuploadangular.fileUploadBackend.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileuploadangular.fileUploadBackend.Models.Post;
import com.fileuploadangular.fileUploadBackend.Repositories.uploadRepo;

@Service
public class UploadService {

    @Autowired
    private uploadRepo uRepo;

    public void insertPost(MultipartFile myFile, String title){
        uRepo.insertPost(myFile, title);
    }

    public Optional<Post> getPost(Integer postId){

       return uRepo.getPost(postId);
        
    }
    
}
