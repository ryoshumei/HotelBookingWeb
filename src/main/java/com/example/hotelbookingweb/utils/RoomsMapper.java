package com.example.hotelbookingweb.utils;

import com.example.hotelbookingweb.entities.RoomEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomsMapper {


    public static List<List<RoomEntity>> divideByFloor(List<RoomEntity> rooms){
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

        // Reverse the list to make it looks like floor 4 ~ floor 2
        Collections.reverse(floors);
        return floors;
    }
}
