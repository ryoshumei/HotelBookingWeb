package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.repositories.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsService {
    private final RoomsRepository roomsRepository;

    public List<RoomEntity> findAllRooms(){ return roomsRepository.findAllRooms();}
}
