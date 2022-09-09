package com.example.day34.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSconfig implements WebMvcConfigurer {

    private String path;
    private String origins;

    public CORSconfig(String p, String o){
        path = p;
        origins = o;
    }


    @Override
    public void addCorsMappings(CorsRegistry corRegistry){

        corRegistry
            .addMapping(path)
            .allowedOrigins(origins);

    }
    
}
