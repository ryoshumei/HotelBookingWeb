package com.example.hotelbookingweb.controllers.admin;

import com.example.hotelbookingweb.services.GuestsService;
import com.example.hotelbookingweb.services.RoomsService;
import com.example.hotelbookingweb.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminIssueController {


    private final GuestsService guestsService;
    private final RoomsService roomsService;
    private final AdminService adminService;

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

    @PostMapping("/admin/checkGuests/delete/{id}")
    public String deleteGuest(Model model, @PathVariable int id){
        System.out.println(id);
        adminService.delete(id);


        return "redirect:/admin/checkGuests";
    }

}
