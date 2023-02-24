package com.example.hotelbookingweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/admin/logIn")
    String login() {
        return "admin/logIn";
    }

    /*@GetMapping("admin/logout")
    @ResponseBody
    String logout() {
        return "login";
    }*/
}
