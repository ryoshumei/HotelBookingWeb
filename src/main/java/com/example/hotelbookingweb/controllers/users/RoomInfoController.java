package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.BookingServiceImpl;
import com.example.hotelbookingweb.services.GuestsServiceImpl;
import com.example.hotelbookingweb.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomInfoController {

    public static final String ROOMS_INFORMATION_PATH = "/roomsInformation";
    public static final String CONFIRM_BOOKING_PATH = "/roomsInformation/confirmBooking";

    private final BookingServiceImpl bookingService;
    private final OrdersService ordersService;


    @PostMapping(CONFIRM_BOOKING_PATH)
    public String confirmBooking(Model model, @ModelAttribute BookingForm bookingForm, RedirectAttributes redirectAttributes){
        if(checkIsAvailable(bookingForm)){
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

    private boolean checkIsAvailable(BookingForm bookingForm){
        List<OrderEntity> orders = ordersService.findAllOrders();

        for(int i = 0; i < orders.size(); i++){
            //todo convert roomId to roomNum
            if(bookingForm.getRoomNum() == orders.get(i).getRoomId() && isDateOverlap(bookingForm,orders.get(i))){
                return false;
            }

        }
        return true;

    }

    private boolean isDateOverlap(BookingForm inputDateForm, OrderEntity order) {
        boolean res;
        if(inputDateForm.getCheckInDate().compareTo(order.getCheckOutDate()) < 0 && order.getCheckInDate().compareTo(inputDateForm.getCheckOutDate()) < 0){
            //then overlap
            res = true;
        } else {
            res = false;
        }
        return res;
    }

}
