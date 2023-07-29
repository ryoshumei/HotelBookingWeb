package com.example.hotelbookingweb.controllers.users;

import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.services.DateCheckerService;
import com.example.hotelbookingweb.services.RoomsService;
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

    public static final String ROOMS_PATH = "/roomsInformation";

    private final RoomsService roomsService;
    private final DateCheckerService dateCheckerService;

    @GetMapping(ROOMS_PATH)
    public String getRooms(Model model, @RequestParam LocalDate checkInDate, @RequestParam LocalDate checkOutDate){

        List<List<RoomEntity>> floors;
        List<RoomEntity> rooms = roomsService.findAllRooms();
        rooms = dateCheckerService.checkIsAvailable(rooms, checkInDate, checkOutDate);

        //Divide list by floor
        //Make a new List OF List
        //Then add it to model
        floors = divideByFloor(rooms);
        model.addAttribute("roomList", floors);
        model.addAttribute("checkInDate", checkInDate);
        model.addAttribute("checkOutDate", checkOutDate);

        return "users/roomsInformation";
    }

}
