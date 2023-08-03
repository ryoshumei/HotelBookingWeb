package com.example.hotelbookingweb.mappers;

import com.example.hotelbookingweb.entities.GuestJoinOrderRoomEntity;
import com.example.hotelbookingweb.model.AdminGuestDTO;

import java.util.ArrayList;
import java.util.List;

public class GuestJoinOrderRoomMapper {
    public static List<AdminGuestDTO> guestJoinOrderRoomToAdminGuestDTO(List<GuestJoinOrderRoomEntity> entities){
        List<AdminGuestDTO> adminGuestDTOS = new ArrayList<>();
        for (GuestJoinOrderRoomEntity entity:entities
             ) {
            AdminGuestDTO adminGuestDTO = AdminGuestDTO.builder()
                    .orderId(entity.getOrderId())
                    .name(entity.getGuestName())
                    .gender(entity.getGuestGender())
                    .age(entity.getGuestAge())
                    .roomNum(entity.getRoomNum())
                    .roomType(entity.getRoomType())
                    .price(entity.getPrice())
                    .payment(entity.getPayment())
                    .checkInDate(entity.getCheckInDate())
                    .checkOutDate(entity.getCheckOutDate())
                    .build();
            adminGuestDTOS.add(adminGuestDTO);
        }

        return adminGuestDTOS;
    }
}
