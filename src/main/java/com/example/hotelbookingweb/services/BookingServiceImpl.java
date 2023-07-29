package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.BookingForm;
import com.example.hotelbookingweb.repositories.GuestsRepository;
import com.example.hotelbookingweb.repositories.OrderRepository;
import com.example.hotelbookingweb.repositories.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final GuestsRepository guestsRepository;
    private final RoomsRepository roomsRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void addOrder(BookingForm bookingForm) {
        GuestEntity guest = GuestEntity.builder()
                .gender(bookingForm.getGender())
                .age(bookingForm.getAge())
                .name(bookingForm.getName())
                .build();
        guestsRepository.insertGuest(guest);
        List<RoomEntity> roomEntities = roomsRepository.findByIds(bookingForm.getRoomNum());
        for (RoomEntity room:roomEntities) {
            OrderEntity order = OrderEntity.builder()
                    .guestId(guest.getId())
                    .roomId(room.getId())
                    .payment("unpaid")
                    .price(room.getPrice())
                    .checkInDate(bookingForm.getCheckInDate())
                    .checkOutDate(bookingForm.getCheckOutDate())
                    .build();
            orderRepository.insertOrder(order);
        }
    }
}
