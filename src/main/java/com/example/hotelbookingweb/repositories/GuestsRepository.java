package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.GuestEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuestsRepository {
    @Select("select * from my_hotel_web.guest_table")
    List<GuestEntity> findAllGuests();

    @Insert("INSERT INTO my_hotel_web.guest_table (name, age, gender) VALUES (#{name}, #{age}, #{gender})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertGuest(GuestEntity guestEntity);

    @Delete("delete from my_hotel_web.guest_table where id = #{id}")
    void deleteById(int id);
}
