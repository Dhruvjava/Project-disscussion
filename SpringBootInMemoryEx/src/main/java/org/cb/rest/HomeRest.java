package org.cb.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeRest {

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }

    @GetMapping("/login")
    public String showlogin(){
        return "login";
    }

    @GetMapping("/hello")
    public String showHello(){
        return "hello";
    }

    @GetMapping("/admin")
    public String showAdmin(){
        return "admin";
    }

    @GetMapping("/customer")
    public String showCust(){
        return "customer";
    }



}
