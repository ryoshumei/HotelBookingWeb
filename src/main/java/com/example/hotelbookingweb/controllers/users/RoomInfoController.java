package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.services.DateCheckerService;
import com.example.hotelbookingweb.services.RoomsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

import static com.example.hotelbookingweb.utils.RoomsMapper.divideByFloor;

@Controller
@RequiredArgsConstructor
public class RoomInfoController {

    public static final String ROOMS_PATH = "/rooms";

    private final RoomsServiceImpl roomsService;
    private final DateCheckerService dateCheckerService;

    @GetMapping(ROOMS_PATH)
    public String getRooms(Model model,@RequestParam() LocalDate checkIn, @RequestParam LocalDate checkOut){

        //todo implement
        List<List<RoomEntity>> floors;
        List<RoomEntity> rooms = roomsService.findAllRooms();//todo not rooms is orders
        rooms = dateCheckerService.checkIsAvailable(rooms,checkIn,checkOut);

        //Divide list by floor
        //Make a new List OF List
        //Then add it to model
        floors = divideByFloor(rooms);
        model.addAttribute("roomList", floors);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);

        return "users/roomsInformation";
    }

}
