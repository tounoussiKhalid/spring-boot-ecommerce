package com.ecommerce.sprintboot.controller;

import com.ecommerce.sprintboot.bean.AuthentificationBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class AuthController {

    @RequestMapping( value = "/403" , method = RequestMethod.GET)
    public String accessDenied(){
        return  "403";
    }

    @RequestMapping(value = "/api/auth/login", method = RequestMethod.GET)
    public AuthentificationBean basicauth()
    {
        return new AuthentificationBean("You are authenticated");
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "/api/auth/admin", method = RequestMethod.GET)
    public String secureHello(){
        System.out.println( "Secure Hello");
        return  "home";
    }

}
