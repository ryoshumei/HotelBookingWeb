package com.example.hotelbookingweb.input_form;


import lombok.Data;

import java.time.LocalDate;

@Data
public class InputDateForm {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfPeople;
}
