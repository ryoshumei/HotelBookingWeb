package com.example.hotelbookingweb.entities;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class GuestEntity {

    private int id;
    private String name;
    private int roomNum;
    private int age;
    private int gender;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
