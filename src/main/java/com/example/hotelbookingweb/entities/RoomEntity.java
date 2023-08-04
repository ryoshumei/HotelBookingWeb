package com.example.hotelbookingweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomEntity {
    private int id;
    private int introduction_id;
    private int roomNum;
    private int floor;
    private int price;
    private String roomType;
    private int roomCapacity;
    private boolean isAvailable;
}
