package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.repositories.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService{

    private final RoomsRepository roomsRepository;
    @Override
    public List<RoomEntity> findAllRooms(){ return roomsRepository.findAllRooms();}
}
