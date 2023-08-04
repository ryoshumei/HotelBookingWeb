package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.RoomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomsRepository {
    @Select("select * from my_hotel_web.room_table")
    List<RoomEntity> findAllRooms();

    @Select({"<script>",
            "select * from my_hotel_web.room_table where room_num in ",
            "<foreach item='item' index='index' collection='list' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"})
    List<RoomEntity> findByIds(List<Integer> roomNum);
}
