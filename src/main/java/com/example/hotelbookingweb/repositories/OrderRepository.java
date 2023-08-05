package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.OrderEntity;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrderRepository {

    @Insert("INSERT INTO order_table(guest_id, room_id, payment, price, check_in_date, check_out_date) VALUES(#{guestId}, #{roomId}, #{payment}, #{price}, #{checkInDate}, #{checkOutDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(OrderEntity order);

    @Select("SELECT * FROM order_table WHERE id = #{id}")
    @Results(id = "OrderResult", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "guestId", column = "guest_id"),
            @Result(property = "roomId", column = "room_id"),
            @Result(property = "payment", column = "payment"),
            @Result(property = "price", column = "price"),
            @Result(property = "checkInDate", column = "check_in_date"),
            @Result(property = "checkOutDate", column = "check_out_date")
    })
    OrderEntity select(int id);

    @Update("UPDATE order_table SET guest_id=#{guestId}, room_id=#{roomId}, payment=#{payment}, price=#{price}, check_in_date=#{checkInDate}, check_out_date=#{checkOutDate} WHERE id=#{id}")
    void update(OrderEntity order);

    @Delete("DELETE FROM order_table WHERE id =#{id}")
    void delete(int id);

    @Select("SELECT * FROM order_table")
    @ResultMap("OrderResult")
    List<OrderEntity> getAll();

    @Insert("INSERT INTO order_table (guest_id, room_id, payment, price, check_in_date, check_out_date) VALUES (#{guestId}, #{roomId}, #{payment}, #{price}, #{checkInDate}, #{checkOutDate})")
    void insertOrder(OrderEntity orderEntity);
}
