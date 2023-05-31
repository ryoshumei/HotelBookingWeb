package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface GuestsRepository {
    @Select("select * from my_hotel_web.guest_table")
    List<GuestEntity> findAllGuests();

    @Insert("insert into my_hotel_web.guest_table (name, room_num, age, gender, check_in_date, check_out_date) VALUES (#{name}, #{roomNum}, #{age}, #{gender}, #{checkInDate}, #{checkOutDate})")
    void insert(String name, int roomNum, Integer age, int gender, LocalDate checkInDate, LocalDate checkOutDate);

    @Delete("delete from my_hotel_web.guest_table where id = #{id}")
    void deleteById(int id);
}
