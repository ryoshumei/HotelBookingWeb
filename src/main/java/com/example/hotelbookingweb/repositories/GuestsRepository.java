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

    @Insert("INSERT INTO my_hotel_web.guest_table (name, age, gender) VALUES (#{name}, #{age}, #{gender})")
    void insertGuest(String name, Integer age, int gender);

    @Delete("delete from my_hotel_web.guest_table where id = #{id}")
    void deleteById(int id);
}
