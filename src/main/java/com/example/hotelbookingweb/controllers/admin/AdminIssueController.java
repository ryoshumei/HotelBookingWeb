package com.example.hotelbookingweb.controllers.admin;

import com.example.hotelbookingweb.services.GuestsService;
import com.example.hotelbookingweb.services.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminIssueController {


    private final GuestsService guestsService;
    private final RoomsService roomsService;

    //TODO Only admin can reach folling sites

    @GetMapping("/admin/checkGuests")
    public String checkGuests(Model model) {
        model.addAttribute("guestsList", guestsService.findAllGuests());
        return "admin/checkGuests";
    }

    @GetMapping("/admin/checkRooms")
    public String checkRooms(Model model) {
        model.addAttribute("roomsList", roomsService.findAllRooms());
        return "admin/checkRooms";
    }

}
