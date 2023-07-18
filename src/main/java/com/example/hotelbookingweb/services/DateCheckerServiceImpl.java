package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.entities.RoomEntity;
import com.example.hotelbookingweb.input_form.BookingForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DateCheckerServiceImpl implements DateCheckerService {

    private final OrdersService ordersService;

    @Override
    public List<RoomEntity> checkIsAvailable(List<RoomEntity> rooms, LocalDate checkIn, LocalDate checkOut){
        List<OrderEntity> orders = ordersService.findAllOrders();

        for(int i = 0; i < orders.size(); i++){
            if(isDateOverlap(checkIn,checkOut,orders.get(i))){
                //todo : find room and setAvailable false
                //todo refactor and double check
                int tempRoomNum = orders.get(i).getRoomId();
                for(int j = 0; j < rooms.size(); j++){
                    if(tempRoomNum == rooms.get(j).getRoomNum()){
                        rooms.get(j).setAvailable(false);
                    }
                }
            }

        }
        return rooms;
    }

    @Override
    public boolean checkIsAvailable(BookingForm bookingForm) {
        List<OrderEntity> orders = ordersService.findAllOrders();
        LocalDate checkIn = bookingForm.getCheckInDate();
        LocalDate checkOut = bookingForm.getCheckOutDate();

        for(int i = 0; i < orders.size(); i++){
            if(isDateOverlap(checkIn,checkOut,orders.get(i))){
                //todo : find room and setAvailable false
                // todo refactor
                int tempRoomNum = orders.get(i).getRoomId();
                for(int j = 0; j < rooms.size(); j++){
                    if(tempRoomNum == rooms.get(j).getRoomNum()){
                        rooms.get(j).setAvailable(false);
                    }
                }
            }

        }
        return false;
    }

    private boolean isDateOverlap(LocalDate checkIn, LocalDate checkOut, OrderEntity order) {
        //todo d-check
        boolean res;
        if(checkIn.compareTo(order.getCheckInDate()) < 0 && order.getCheckInDate().compareTo(checkOut) < 0){
            //then overlap
            res = true;
        } else {
            res = false;
        }
        return res;
    }
}
