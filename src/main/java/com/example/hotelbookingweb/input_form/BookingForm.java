package com.example.hotelbookingweb.input_form;

import lombok.Data;

import java.time.LocalDate;


@Data
public class BookingForm {

    private String name;
    private int roomNum;
    private Integer age;
    private int gender;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
