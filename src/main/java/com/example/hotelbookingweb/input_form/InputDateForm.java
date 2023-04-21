package com.example.hotelbookingweb.input_form;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InputDateForm {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfPeople;

    public InputDateForm(LocalDate checkInDate, LocalDate checkOutDate, int numOfPeople) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numOfPeople = numOfPeople;
    }

    public InputDateForm() {
    }
}
