package com.example.hotelbookingweb.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AdminGuestDTO {
    private int orderId;
    private String name;
    private int gender;
    private int age;
    private int roomNum;
    private String roomType;
    private int price;
    private String payment;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
