package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.repositories.GuestsRepository;
import com.example.hotelbookingweb.repositories.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestsService {

    private final GuestsRepository guestsRepository;
    public List<GuestEntity> findAllGuests(){
        return guestsRepository.findAllGuests();
    }


}
