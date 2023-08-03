package com.example.hotelbookingweb.entities;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GuestJoinOrderRoomEntity {
    private Integer guestId;
    private String guestName;
    private Integer guestAge;
    private Integer guestGender;

    private Integer roomId;
    private Integer roomNum;
    private Integer floor;
    private Integer price;
    private String roomType;
    private Integer roomCapacity;
    private Boolean isAvailable;

    private Integer orderId;
    private String payment;
    private Integer orderPrice;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
