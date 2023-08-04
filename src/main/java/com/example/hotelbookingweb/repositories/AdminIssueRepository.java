package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.GuestJoinOrderRoomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminIssueRepository {
    @Select("SELECT g.id as guest_id, g.name as guest_name, g.age as guest_age, g.gender as guest_gender, " +
            "r.id as room_id, r.room_num as room_number, r.floor as room_floor, r.price as room_price, r.room_type as room_type, r.room_capacity as room_capacity, r.is_available as room_availability, " +
            "o.id as order_id, o.payment as order_payment, o.price as order_price, o.check_in_date as check_in_date, o.check_out_date as check_out_date " +
            "FROM guest_table g " +
            "JOIN order_table o ON g.id = o.guest_id " +
            "JOIN room_table r ON o.room_id = r.id")
    @Results({
            @Result(property = "guestId", column = "guest_id"),
            @Result(property = "guestName", column = "guest_name"),
            @Result(property = "guestAge", column = "guest_age"),
            @Result(property = "guestGender", column = "guest_gender"),
            @Result(property = "roomId", column = "room_id"),
            @Result(property = "roomNum", column = "room_number"),
            @Result(property = "floor", column = "room_floor"),
            @Result(property = "price", column = "room_price"),
            @Result(property = "roomType", column = "room_type"),
            @Result(property = "roomCapacity", column = "room_capacity"),
            @Result(property = "isAvailable", column = "room_availability"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "payment", column = "order_payment"),
            @Result(property = "orderPrice", column = "order_price"),
            @Result(property = "checkInDate", column = "check_in_date"),
            @Result(property = "checkOutDate", column = "check_out_date")
    })
    List<GuestJoinOrderRoomEntity> getGuestJoinOrderRooms();
}
