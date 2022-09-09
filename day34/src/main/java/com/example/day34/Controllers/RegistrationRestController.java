package com.example.day34.Controllers;

import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day34.Models.Registration;
import com.example.day34.Models.Response;

@RestController
@RequestMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegistrationRestController {

    private Logger logger = Logger.getLogger(RegistrationRestController.class.getName());

    @PostMapping(path="/api/registration",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>registration(@RequestBody String payload){


        Response resp;
        Registration reg;
        logger.info("Payload: %s".formatted(payload));


        // Read the payload and save the data to DB
        String id = UUID.randomUUID().toString().substring(0,8);

        try{
        reg = Registration.create(payload);
        reg.setId(id);
        } catch(Exception ex){
            resp = new Response();
            resp.setCode(400);
            resp.setMessage(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp.toJson().toString());
        }

        //Save to database

        resp = new Response();
        resp.setCode(201);
        resp.setMessage(id);
        resp.setData(reg.toString());

        return ResponseEntity
            .status(HttpStatus.CREATED).body(resp.toJson().toString());

    }
    
}
