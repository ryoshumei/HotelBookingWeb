package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.repositories.GuestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestsServiceImpl implements GuestsService{

    private final GuestsRepository guestsRepository;
    @Override
    public List<GuestEntity> findAllGuests(){
        return guestsRepository.findAllGuests();
    }


}
