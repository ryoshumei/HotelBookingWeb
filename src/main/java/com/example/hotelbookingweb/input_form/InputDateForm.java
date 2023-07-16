package com.example.hotelbookingweb.input_form;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InputDateForm {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
