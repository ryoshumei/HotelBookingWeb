package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.BookingForm;

import java.time.LocalDate;
import java.util.List;

public interface DateCheckerService {
    List<RoomEntity> checkIsAvailable(List<RoomEntity> rooms, LocalDate checkIn, LocalDate checkOut);
    boolean checkIsAvailable(BookingForm bookingForm);
}
