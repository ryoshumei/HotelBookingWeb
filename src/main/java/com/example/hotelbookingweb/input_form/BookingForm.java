package com.example.hotelbookingweb.input_form;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
public class BookingForm {

    private String name;
    private List<Integer> roomNum;
    private Integer age;
    private Integer gender;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
