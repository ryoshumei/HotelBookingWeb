package com.example.hotelbookingweb.entities;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OrderEntity {
    private int id;
    private int guestId;
    private int roomId;
    private String payment;
    private int price;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
