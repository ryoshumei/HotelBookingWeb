package com.example.hotelbookingweb.controllers;


import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.InputDateForm;
import com.example.hotelbookingweb.services.GuestsService;
import com.example.hotelbookingweb.services.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class indexController {
    private final RoomsService roomsService;
    private final GuestsService guestsService;

    @GetMapping("/")
    public String index(@ModelAttribute InputDateForm inputDateForm, Model model) {


        return "index";
    }

    @PostMapping("/")
    public String searchRooms(@ModelAttribute InputDateForm inputDateForm, Model model){
        //System.out.println(inputDateForm.getCheckInDate());
        //System.out.println(inputDateForm.getCheckOutDate());
        //System.out.println(inputDateForm.getNumOfPeople());


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
        List<GuestEntity> guests = guestsService.findAllGuests();

        for(int i = 0; i < guests.size(); i++){
            if(isDateOverlap(inputDateForm,guests.get(i))){
                //done : find room and setAvailable false
                int tempRoomNum = guests.get(i).getRoomNum();
                for(int j = 0; j < rooms.size(); j++){
                    if(tempRoomNum == rooms.get(j).getRoomNum()){
                        rooms.get(j).setAvailable(false);
                    }
                }
            }

        }
        // if traveler > room_max_capacity set it false
        for(int i = 0; i < rooms.size(); i++){
            if(inputDateForm.getNumOfPeople() > rooms.get(i).getRoomCapacity()){
                rooms.get(i).setAvailable(false);
            }
        }

        return rooms;

    }

    private boolean isDateOverlap(InputDateForm inputDateForm, GuestEntity guests) {
        boolean res;
        if(inputDateForm.getCheckInDate().compareTo(guests.getCheckOutDate()) < 0 && guests.getCheckInDate().compareTo(inputDateForm.getCheckOutDate()) < 0){
            //then overlap
            res = true;
        } else {
            res = false;
        }
        return res;
    }


}
