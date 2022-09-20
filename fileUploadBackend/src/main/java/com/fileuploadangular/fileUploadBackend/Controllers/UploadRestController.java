package com.fileuploadangular.fileUploadBackend.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileuploadangular.fileUploadBackend.Models.Post;
import com.fileuploadangular.fileUploadBackend.Services.UploadService;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path="/upload")
public class UploadRestController {

    @Autowired
    private UploadService uploadSvc;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> postUpload(@RequestPart MultipartFile myFile, @RequestPart String title){

        uploadSvc.insertPost(myFile, title);

        JsonObject data = Json.createObjectBuilder()
            .add("content-type", myFile.getContentType())
            .add("name", myFile.getName())
            .add("original_name", myFile.getOriginalFilename())
            .add("size", myFile.getSize())
            .add("form_name", title)
            .build();
        
        return ResponseEntity.ok(data.toString());
    }

    @GetMapping(path="{id}")
    public ResponseEntity<byte[]> getUpload(@PathVariable Integer id) {
        Optional<Post> opt = uploadSvc.getPost(id);
        Post p = opt.get();

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.parseMediaType(p.getMediaType()))
                .body(p.getContent());
    }
    
}
