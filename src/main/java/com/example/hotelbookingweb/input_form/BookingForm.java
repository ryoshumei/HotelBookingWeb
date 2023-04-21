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

    public BookingForm(String name, int roomNum, Integer age, int gender, LocalDate checkInDate, LocalDate checkOutDate) {
        this.name = name;
        this.roomNum = roomNum;
        this.age = age;
        this.gender = gender;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public BookingForm() {
    }
}
