package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.WebSecurityConfig;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.BookingServiceImpl;
import com.example.hotelbookingweb.services.DateCheckerService;
import com.example.hotelbookingweb.services.GuestsServiceImpl;
import com.example.hotelbookingweb.services.RoomsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotelbookingweb.controllers.users.BookingFormController.BOOKING_FORM_PATH;
import static com.example.hotelbookingweb.controllers.users.BookingFormController.ROOMS_INFORMATION_PATH;
import static com.example.hotelbookingweb.controllers.users.RoomInfoController.ROOMS_PATH;
import static org.mockito.BDDMockito.given;
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

    @MockBean
    RoomsService roomsService;

    @MockBean
    DateCheckerService dateCheckerService;

    @Test
    void findAllRooms() throws Exception {

        InputDateForm inputDateForm = new InputDateForm(LocalDate.of(2023,3,28),LocalDate.of(2023,4,2));

        List<RoomEntity> rooms = new ArrayList<>();
        RoomEntity testRoom = new RoomEntity(1,1,209,2,8000,"test",2,true);
        rooms.add(testRoom);

        given(roomsService.findAllRooms()).willReturn(rooms);
        given(dateCheckerService.checkIsAvailable(rooms,inputDateForm.getCheckInDate(),inputDateForm.getCheckOutDate())).willReturn(rooms);
        mockMvc.perform(get(ROOMS_PATH)
                        .param("checkIn",inputDateForm.getCheckInDate().toString())
                        .param("checkOut",inputDateForm.getCheckOutDate().toString()))
                .andExpect(view().name("users/roomsInformation"))
                .andExpect(status().isOk());
    }
}