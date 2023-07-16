package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.GuestEntity;

import java.util.List;

public interface GuestsService {
    List<GuestEntity> findAllGuests();
}
