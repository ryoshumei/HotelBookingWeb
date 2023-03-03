package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.BookingService;
import com.example.hotelbookingweb.services.GuestsService;
import com.example.hotelbookingweb.services.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomInfoController {
    private final BookingService bookingService;
    private final GuestsService guestsService;


    @PostMapping("/roomsInformation/confirmBooking")
    public String confirmBooking(Model model, @ModelAttribute BookingForm bookingForm, RedirectAttributes redirectAttributes){
        if(checkIsAvailable(bookingForm)){
            bookingService.create(bookingForm);
        } else {
            redirectAttributes.addFlashAttribute("hasConflict",true);
            return "redirect:/";
        }

        System.out.println(bookingForm);

        model.addAttribute("bookingCompleteInfo",bookingForm);
        return "users/bookingComplete";
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

    private boolean checkIsAvailable(BookingForm bookingForm){
        List<GuestEntity> guests = guestsService.findAllGuests();

        for(int i = 0; i < guests.size(); i++){
            if(bookingForm.getRoomNum() == guests.get(i).getRoomNum() && isDateOverlap(bookingForm,guests.get(i))){
                return false;
            }

        }
        return true;

    }

    private boolean isDateOverlap(BookingForm inputDateForm, GuestEntity guests) {
        boolean res;
        if(inputDateForm.getCheckInDate().compareTo(guests.getCheckOutDate()) < 0 && guests.getCheckInDate().compareTo(inputDateForm.getCheckOutDate()) < 0){
            //then overlap
            res = true;
        } else {
            res = false;
        }
        return res;
    }

}
