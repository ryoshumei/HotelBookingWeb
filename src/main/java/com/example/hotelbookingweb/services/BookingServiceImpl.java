package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.repositories.GuestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final GuestsRepository guestsRepository;

    @Override
    @Transactional
    public void addOrder(BookingForm bookingForm) {
        guestsRepository.insertGuest(
                //todo refactor fix
                bookingForm.getName(),
                bookingForm.getAge(),
                bookingForm.getGender()
        );
    }
}
