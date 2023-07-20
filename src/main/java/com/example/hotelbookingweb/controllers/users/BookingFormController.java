package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.BookingServiceImpl;
import com.example.hotelbookingweb.services.DateCheckerService;
import com.example.hotelbookingweb.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class BookingFormController {

    public static final String ROOMS_INFORMATION_PATH = "/roomsInformation";
    public static final String BOOKING_FORM_PATH = "/roomsInformation/confirmBooking";
    public static final String BOOKING_COMPLETE_PATH = "/roomsInformation/confirmBooking/complete";

    private final BookingServiceImpl bookingService;
    private final DateCheckerService dateCheckerService;

    @PostMapping(BOOKING_FORM_PATH)
    public String confirmBooking(Model model, @ModelAttribute BookingForm bookingForm, RedirectAttributes redirectAttributes){
        if(dateCheckerService.checkIsAvailable(bookingForm)){
            bookingService.addOrder(bookingForm);
        } else {
            redirectAttributes.addFlashAttribute("hasConflict",true);
            return "redirect:/";
        }
        model.addAttribute("bookingCompleteInfo",bookingForm);
        return "users/bookingComplete";
    }

    @GetMapping(BOOKING_FORM_PATH)
    public String getBookingForm(Model model,
                            @RequestParam("checkInDate") String checkInDate,
                            @RequestParam("checkOutDate") String checkOutDate,
                            @RequestParam("roomNum") ArrayList<Integer> roomNums,
                            @RequestParam(value = "numOfPeople",required = false) int numOfPeople,
                            @ModelAttribute InputDateForm inputDateForm,
                            @ModelAttribute BookingForm bookingForm){

        inputDateForm.setCheckInDate(LocalDate.parse(checkInDate));
        inputDateForm.setCheckOutDate(LocalDate.parse(checkOutDate));
        model.addAttribute("date", inputDateForm);
        model.addAttribute("roomNum", roomNums);

        return "users/guestBookingForm";
    }

}
