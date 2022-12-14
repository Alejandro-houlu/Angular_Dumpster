package com.example.day34.Models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

public class Registration {
   private String id;
   private String name;
   private String email;

public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}



@Override
public String toString() {
    return "Registration [email=" + email + ", id=" + id + ", name=" + name + "]";
}
public static Registration create(String json){

    JsonObjectBuilder builder = Json.createObjectBuilder();
    JsonReader reader = Json.createReader(new StringReader(json));
    JsonObject data = reader.readObject();

    final Registration reg = new Registration();
    reg.setName(data.getString("name"));
    reg.setEmail(data.getString("email"));

    if(data.containsKey("id")){reg.setId(data.getString("id"));}

    return reg;
}

   
   
}
