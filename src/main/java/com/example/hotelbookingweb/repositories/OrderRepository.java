package com.example.hotelbookingweb.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface OrderRepository {

    @Insert("INSERT INTO my_hotel_web.order_table (guest_id, room_num, check_in_date, check_out_date) VALUES (#{guestId}, #{roomNum}, #{checkInDate}, #{checkOutDate})")
    void insertOrder(int guestId, int roomNum, LocalDate checkInDate, LocalDate checkOutDate);
}
