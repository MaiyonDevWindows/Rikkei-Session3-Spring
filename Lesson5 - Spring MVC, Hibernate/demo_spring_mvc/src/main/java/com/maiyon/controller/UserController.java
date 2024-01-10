package com.maiyon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/post-register")
    public String postRegister(HttpServletRequest request){
        System.out.println(request.getParameter("fullName"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("retypePassword"));
        return "redirect:/";
    }
}
