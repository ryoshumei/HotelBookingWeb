package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.repositories.GuestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final GuestsRepository guestsRepository;

    @Transactional
    public void create(BookingForm bookingForm) {
        guestsRepository.insert(
                bookingForm.getName(),
                bookingForm.getRoomNum(),
                bookingForm.getAge(),
                bookingForm.getGender(),
                bookingForm.getCheckInDate(),
                bookingForm.getCheckOutDate());
    }
}
