package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.WebSecurityConfig;
import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.BookingServiceImpl;
import com.example.hotelbookingweb.services.GuestsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static com.example.hotelbookingweb.controllers.users.RoomInfoController.CONFIRM_BOOKING_PATH;
import static com.example.hotelbookingweb.controllers.users.RoomInfoController.ROOMS_INFORMATION_PATH;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomInfoController.class)
@Import(WebSecurityConfig.class)
class RoomInfoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookingServiceImpl bookingService;

    @MockBean
    GuestsServiceImpl guestsService;

    @Test
    void confirmBooking() throws Exception {

        BookingForm bookingForm = new BookingForm("test", 202, 26,0 ,LocalDate.of(2023,3,28),LocalDate.of(2023,4,2));

        mockMvc.perform(post(CONFIRM_BOOKING_PATH)
                        .flashAttr("bookingForm",bookingForm)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("users/bookingComplete"));
    }

    @Test
    void showRooms() throws Exception {

        InputDateForm inputDateForm = new InputDateForm(LocalDate.of(2023,3,28),LocalDate.of(2023,4,2));

        String checkInDate = inputDateForm.getCheckInDate().toString();

        mockMvc.perform(get(ROOMS_INFORMATION_PATH)
                        .param("checkInDate",checkInDate)
                        .param("checkOutDate",inputDateForm.getCheckOutDate().toString())
                        .param("roomNum","402")
                        .param("numOfPeople","2"))
                .andExpect(status().isOk())
                .andExpect(view().name("users/guestBookingForm"));
    }
}