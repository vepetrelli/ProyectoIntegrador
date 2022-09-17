package com.portfolio.portfolio.Security.Dto;


public class JwtDto {
     private String token;

    
    //constructor

     public JwtDto(String token) {
        this.token = token;
    }
    //Getters and Setters

 
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}