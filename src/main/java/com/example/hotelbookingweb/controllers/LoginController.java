package com.example.hotelbookingweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    public static final String LOGIN_PATH = "/admin/logIn";

    @GetMapping(LOGIN_PATH)
    String login() {
        return "admin/logIn";
    }

}
