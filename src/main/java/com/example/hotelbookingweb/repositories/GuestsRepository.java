package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.GuestEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuestsRepository {
    @Select("select * from guest_table")
    List<GuestEntity> findAllGuests();

    @Insert("INSERT INTO guest_table (name, age, gender) VALUES (#{name}, #{age}, #{gender})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertGuest(GuestEntity guestEntity);

    @Delete("delete from guest_table where id = #{id}")
    void deleteById(int id);
}
