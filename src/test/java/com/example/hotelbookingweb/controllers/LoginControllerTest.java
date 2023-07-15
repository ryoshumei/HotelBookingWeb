package com.example.hotelbookingweb.controllers;

import com.example.hotelbookingweb.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.hotelbookingweb.controllers.LoginController.LOGIN_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoginController.class)
@Import(WebSecurityConfig.class)
class LoginControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void login() throws Exception {
        mockMvc.perform(get(LOGIN_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/logIn"));
    }
}