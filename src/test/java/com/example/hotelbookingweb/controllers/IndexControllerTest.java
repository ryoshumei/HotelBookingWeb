package com.example.hotelbookingweb.controllers;

import com.example.hotelbookingweb.WebSecurityConfig;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.GuestsServiceImpl;
import com.example.hotelbookingweb.services.RoomsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotelbookingweb.controllers.IndexController.HOME_PATH;
import static com.example.hotelbookingweb.controllers.users.RoomInfoController.ROOMS_PATH;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IndexController.class)
@Import(WebSecurityConfig.class)
class IndexControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RoomsServiceImpl roomsService;

    @MockBean
    GuestsServiceImpl guestsService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void index() throws Exception {

        Path indexPath = Paths.get("templates/index.html");
        String indexContentType = Files.probeContentType(indexPath);

        mockMvc.perform(get(HOME_PATH)
                .accept(MediaType.TEXT_HTML_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(indexContentType))
                //.andExpect(content().contentType(MediaType.TEXT_HTML_UTF8))
                .andExpect(view().name("index"));

    }

}