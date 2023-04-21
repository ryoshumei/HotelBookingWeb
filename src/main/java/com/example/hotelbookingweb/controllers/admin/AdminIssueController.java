package com.example.hotelbookingweb.controllers.admin;

import com.example.hotelbookingweb.services.GuestsService;
import com.example.hotelbookingweb.services.RoomsService;
import com.example.hotelbookingweb.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminIssueController {

    public static final String CHECK_GUESTS_PATH = "/admin/checkGuests";
    public static final String CHECK_ROOMS_PATH = "/admin/checkRooms";
    public static final String DELETE_GUEST_PATH = "/admin/checkGuests/delete/{id}";


    private final GuestsService guestsService;
    private final RoomsService roomsService;
    private final AdminService adminService;



    @GetMapping(CHECK_GUESTS_PATH)
    public String checkGuests(Model model) {
        model.addAttribute("guestsList", guestsService.findAllGuests());
        return "admin/checkGuests";
    }

    @GetMapping(CHECK_ROOMS_PATH)
    public String checkRooms(Model model) {
        model.addAttribute("roomsList", roomsService.findAllRooms());
        return "admin/checkRooms";
    }

    @PostMapping(DELETE_GUEST_PATH)
    public String deleteGuest(Model model, @PathVariable int id){
        System.out.println(id);
        adminService.delete(id);


        return "redirect:/admin/checkGuests";
    }

}
