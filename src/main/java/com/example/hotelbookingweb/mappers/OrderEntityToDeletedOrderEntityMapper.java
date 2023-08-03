package com.example.hotelbookingweb.mappers;

import com.example.hotelbookingweb.entities.DeletedOrderEntity;
import com.example.hotelbookingweb.entities.OrderEntity;

public class OrderEntityToDeletedOrderEntityMapper {
    public static DeletedOrderEntity toDeletedOrderEntity(OrderEntity orderEntity){
        DeletedOrderEntity deletedOrderEntity = DeletedOrderEntity.builder()
                .orderId(orderEntity.getId())
                .guestId(orderEntity.getGuestId())
                .roomId(orderEntity.getRoomId())
                .payment(orderEntity.getPayment())
                .price(orderEntity.getPrice())
                .checkInDate(orderEntity.getCheckInDate())
                .checkOutDate(orderEntity.getCheckOutDate())
                .build();
        return deletedOrderEntity;
    }
}
