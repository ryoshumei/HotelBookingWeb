package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.WebSecurityConfig;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotelbookingweb.controllers.users.BookingFormController.BOOKING_FORM_PATH;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(BookingFormController.class)
@Import(WebSecurityConfig.class)
class BookingFormControllerTest {

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
    void confirmBooking() throws Exception{
        BookingForm bookingForm = new BookingForm("test", List.of(204,205), 26,1 ,LocalDate.of(2023,3,28),LocalDate.of(2023,4,2));
        given(dateCheckerService.checkIsAvailable(bookingForm)).willReturn(true);
        mockMvc.perform(post(BOOKING_FORM_PATH)
                        .flashAttr("bookingForm",bookingForm)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("users/bookingComplete"));
    }

    @Test
    void getBookingForm() throws Exception{
        InputDateForm inputDateForm = new InputDateForm(LocalDate.of(2023,3,28),LocalDate.of(2023,4,2));

        String checkInDate = inputDateForm.getCheckInDate().toString();
        List<Integer> roomNum = new ArrayList<>();
        roomNum.add(402);
        roomNum.add(403);

        MockHttpServletRequestBuilder request = get(BOOKING_FORM_PATH)
                .param("checkInDate", checkInDate)
                .param("checkOutDate", inputDateForm.getCheckOutDate().toString())
                .param("numOfPeople", Integer.toString(2))
                .accept(MediaType.TEXT_HTML_VALUE);

        for (Integer num : roomNum) {
            request = request.param("roomNum", num.toString());
        }

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("users/guestBookingForm"));

    }
}