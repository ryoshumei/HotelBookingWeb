package com.example.hotelbookingweb.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
public class GuestEntity {

    private int id;
    private String name;
    private int age;
    private int gender;
}
