package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.DeletedOrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface DeletedOrderRepository {
    @Insert("INSERT INTO deleted_order_table(order_id, guest_id, room_id, payment, price, check_in_date, check_out_date, deleted_date_time) VALUES(#{orderId}, #{guestId}, #{roomId}, #{payment}, #{price}, #{checkInDate}, #{checkOutDate}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(DeletedOrderEntity deletedOrderEntity);
}
