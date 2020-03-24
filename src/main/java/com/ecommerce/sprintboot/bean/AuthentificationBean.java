package com.ecommerce.sprintboot.bean;

public class AuthentificationBean {

    private String message;

   public AuthentificationBean( String message){
       this.message = message;
   }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthentificationBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
