package com.example.hotelbookingweb.controllers;


import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.GuestsServiceImpl;
import com.example.hotelbookingweb.services.OrdersService;
import com.example.hotelbookingweb.services.RoomsServiceImpl;
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
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    public static final String HOME_PATH = "/";

    @GetMapping(HOME_PATH)
    public String index(@ModelAttribute InputDateForm inputDateForm, Model model, RedirectAttributes redirectAttributes) {
        boolean hasConflict = false;

        if(redirectAttributes.getFlashAttributes().get("hasConflict") != null){
            hasConflict =(boolean) redirectAttributes.getFlashAttributes().get("hasConflict");
        }
        if(hasConflict){
            model.addAttribute("hasConflict", true);
        }
        return "index";
    }
}
