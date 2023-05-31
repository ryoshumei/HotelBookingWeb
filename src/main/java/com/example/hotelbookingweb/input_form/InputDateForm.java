package com.example.hotelbookingweb.input_form;


import lombok.Data;

import java.time.LocalDate;

@Data
public class InputDateForm {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;


    public InputDateForm(LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }


}
