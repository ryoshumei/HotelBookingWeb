package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(RoomInfoController.class)
@Import(WebSecurityConfig.class)
class RoomInfoControllerTest {

    @Test
    void confirmBooking() {
    }

    @Test
    void showRooms() {
    }
}