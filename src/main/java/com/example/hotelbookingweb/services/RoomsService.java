package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.RoomEntity;

import java.util.List;

public interface RoomsService {
    List<RoomEntity> findAllRooms();
}
