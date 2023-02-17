package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.RoomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomsRepository {
    @Select("select * from my_hotel_web.roomtable")
    List<RoomEntity> findAllRooms();
}
