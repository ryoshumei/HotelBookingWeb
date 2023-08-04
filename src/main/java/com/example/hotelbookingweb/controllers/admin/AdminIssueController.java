package com.example.hotelbookingweb.controllers.admin;

import com.example.hotelbookingweb.services.RoomsServiceImpl;
import com.example.hotelbookingweb.services.admin.AdminIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminIssueController {

    public static final String CHECK_GUESTS_PATH = "/admin/checkGuests";
    public static final String CHECK_ROOMS_PATH = "/admin/checkRooms";
    public static final String DELETE_GUEST_PATH = "/admin/checkGuests/delete/{id}";
    public static final String UPDATE_PAYMENT_TO_PAID = "/admin/checkGuests/updatePayment/{id}";

    private final AdminIssueService adminIssueService;
    private final RoomsServiceImpl roomsService;

    @GetMapping(CHECK_GUESTS_PATH)
    public String checkGuests(Model model) {
        model.addAttribute("guestsList", adminIssueService.getAllGuestOrders());
        return "admin/checkGuests";
    }

    @GetMapping(CHECK_ROOMS_PATH)
    public String checkRooms(Model model) {
        model.addAttribute("roomsList", roomsService.findAllRooms());
        return "admin/checkRooms";
    }

    @PostMapping(DELETE_GUEST_PATH)
    public String deleteGuest(Model model, @PathVariable int id){
        adminIssueService.deleteOrderByOrderId(id);
        return "redirect:/admin/checkGuests";
    }

    @PostMapping(UPDATE_PAYMENT_TO_PAID)
    public String updatePaymentToPaid(Model model, @PathVariable int id){
        adminIssueService.updatePaymentToPaid(id);
        return "redirect:/admin/checkGuests";
    }

}
