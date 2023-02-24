package com.example.hotelbookingweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AdminEntity {

    private int id;
    private String adminId;
    private String password;
    private String role;
}
