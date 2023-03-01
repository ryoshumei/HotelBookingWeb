package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.BookingService;
import com.example.hotelbookingweb.services.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomInfoController {
    private final RoomsService roomsService;
    private final BookingService bookingService;


    @PostMapping("/roomsInformation/confirmBooking")
    //@ResponseBody
    public String confirmBooking(Model model, @ModelAttribute BookingForm bookingForm){

        bookingService.create(bookingForm);
        System.out.println(bookingForm);

        model.addAttribute("bookingCompleteInfo",bookingForm);
        return "users/bookingComplete";
        //return "Complete   :    <br>" + bookingForm.toString();
    }

    @GetMapping("/roomsInformation")
    public String showRooms(@RequestParam("checkInDate") String checkInDate,
                            @RequestParam("checkOutDate") String checkOutDate,
                            @RequestParam("roomNum") int roomNum,
                            @RequestParam("numOfPeople") int numOfPeople,
                            Model model,
                            @ModelAttribute InputDateForm inputDateForm,
                            @ModelAttribute BookingForm bookingForm){


        inputDateForm.setCheckInDate(LocalDate.parse(checkInDate));
        inputDateForm.setCheckOutDate(LocalDate.parse(checkOutDate));
        inputDateForm.setNumOfPeople(numOfPeople);


        //test
        /*
        System.out.println(inputDateForm.getCheckInDate());
        System.out.println(inputDateForm.getCheckOutDate());
        System.out.println(inputDateForm.getNumOfPeople());
        */
        //end test

        model.addAttribute("numOfPeople", numOfPeople);
        model.addAttribute("date", inputDateForm);
        model.addAttribute("roomNum", roomNum);

        return "users/guestBookingForm";
    }

}
