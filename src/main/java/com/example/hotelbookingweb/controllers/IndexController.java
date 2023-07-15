package com.example.hotelbookingweb.controllers;


import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.GuestsService;
import com.example.hotelbookingweb.services.OrdersService;
import com.example.hotelbookingweb.services.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    public static final String HOME_PATH = "/";

    private final RoomsService roomsService;
    private final GuestsService guestsService;
    private final OrdersService ordersService;

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

    @PostMapping(HOME_PATH)//todo : convert to GetMapping
    public String searchRooms(@ModelAttribute InputDateForm inputDateForm, Model model){

        List<List<RoomEntity>> floors;
        List<RoomEntity> rooms = roomsService.findAllRooms();
        rooms = checkIsAvailable(rooms,inputDateForm);

        //Divide list by floor
        //Make a new LIST OF LIST
        //Then add it to model
        floors = divideByFloor(rooms);
        model.addAttribute("roomList", floors);
        model.addAttribute("date", inputDateForm);

        //DONE jump to roomsInformation.html
        return "users/roomsInformation";
    }

    private List<List<RoomEntity>> divideByFloor(List<RoomEntity> rooms){
        List<List<RoomEntity>> floors = new ArrayList<>();

        //Divide list by floor
        //Make a new LIST OF LIST
        int curFloor = rooms.get(0).getFloor();
        List<RoomEntity> tempRooms = new ArrayList<>();
        //System.out.println(tempRooms.isEmpty());
        for(int i = 0; i < rooms.size(); i++){
            //cast to RoomToShow Class

            if(rooms.get(i).getFloor() == curFloor){
                tempRooms.add(rooms.get(i));
            } else {
                floors.add(tempRooms);
                tempRooms = new ArrayList();
                curFloor = rooms.get(i).getFloor();
                i--;
            }
        }
        if(!tempRooms.isEmpty()){
            floors.add(tempRooms);
        }

        // Reverse the list to make it looks like from floor 4 ~ floor 2
        Collections.reverse(floors);
        return floors;
    }

    private List<RoomEntity> checkIsAvailable(List<RoomEntity> rooms, InputDateForm inputDateForm){

        List<OrderEntity> orders = ordersService.findAllOrders();

        for(int i = 0; i < orders.size(); i++){
            if(isDateOverlap(inputDateForm,orders.get(i))){
                //todo : find room and setAvailable false
                int tempRoomNum = orders.get(i).getRoomId();
                for(int j = 0; j < rooms.size(); j++){
                    if(tempRoomNum == rooms.get(j).getRoomNum()){
                        rooms.get(j).setAvailable(false);
                    }
                }
            }

        }
        return rooms;
    }

    private boolean isDateOverlap(InputDateForm inputDateForm, OrderEntity order) {
        //todo check
        boolean res;
        if(inputDateForm.getCheckInDate().compareTo(order.getCheckInDate()) < 0 && order.getCheckInDate().compareTo(inputDateForm.getCheckOutDate()) < 0){
            //then overlap
            res = true;
        } else {
            res = false;
        }
        return res;
    }
}
