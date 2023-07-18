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

@Controller
@RequiredArgsConstructor
public class BookingFormController {

    public static final String ROOMS_INFORMATION_PATH = "/roomsInformation";
    public static final String CONFIRM_BOOKING_PATH = "/roomsInformation/confirmBooking";

    private final BookingServiceImpl bookingService;
    private final OrdersService ordersService;
    private final DateCheckerService dateCheckerService;

    @PostMapping(CONFIRM_BOOKING_PATH)
    public String confirmBooking(Model model, @ModelAttribute BookingForm bookingForm, RedirectAttributes redirectAttributes){
        if(dateCheckerService.checkIsAvailable(bookingForm)){
            bookingService.addOrder(bookingForm);
        } else {
            redirectAttributes.addFlashAttribute("hasConflict",true);
            return "redirect:/";
        }

        //System.out.println(bookingForm);

        model.addAttribute("bookingCompleteInfo",bookingForm);
        return "users/bookingComplete";
    }

    @GetMapping(ROOMS_INFORMATION_PATH)
    public String showRooms(@RequestParam("checkInDate") String checkInDate,
                            @RequestParam("checkOutDate") String checkOutDate,
                            @RequestParam("roomNum") int roomNum,
                            @RequestParam(value = "numOfPeople",required = false) int numOfPeople,
                            Model model,
                            @ModelAttribute InputDateForm inputDateForm,
                            @ModelAttribute BookingForm bookingForm){


        inputDateForm.setCheckInDate(LocalDate.parse(checkInDate));
        inputDateForm.setCheckOutDate(LocalDate.parse(checkOutDate));
        //inputDateForm.setNumOfPeople(numOfPeople);


        //test
        /*
        System.out.println(inputDateForm.getCheckInDate());
        System.out.println(inputDateForm.getCheckOutDate());
        System.out.println(inputDateForm.getNumOfPeople());
        */
        //end test

        //model.addAttribute("numOfPeople", numOfPeople);
        model.addAttribute("date", inputDateForm);
        model.addAttribute("roomNum", roomNum);

        return "users/guestBookingForm";
    }

}
