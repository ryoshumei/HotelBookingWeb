package com.example.hotelbookingweb.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class DeletedOrderEntity {
    private int id;
    private int orderId;
    private int guestId;
    private int roomId;
    private String payment;
    private int price;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime deletedDateTime;
}
