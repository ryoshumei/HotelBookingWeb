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
    private final RoomsService roomsService;

    @Override
    public List<RoomEntity> checkIsAvailable(List<RoomEntity> rooms, LocalDate checkIn, LocalDate checkOut){
        List<OrderEntity> orders = ordersService.findAllOrders();

        for(int i = 0; i < orders.size(); i++){
            if(isDateOverlap(checkIn,checkOut,orders.get(i))){
                //todo : find room and setAvailable false
                int thisRoomId = orders.get(i).getRoomId();
                int tempRoomNum = findRoomNum(rooms, thisRoomId);
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
        List<RoomEntity> rooms = roomsService.findAllRooms();
        LocalDate checkIn = bookingForm.getCheckInDate();
        LocalDate checkOut = bookingForm.getCheckOutDate();

        for(int i = 0; i < orders.size(); i++){
            int roomId = orders.get(i).getRoomId();
            int thisRoomNum = findRoomNum(rooms, roomId);
            for (Integer bookingRoomNum: bookingForm.getRoomNum()) {
                if(thisRoomNum == bookingRoomNum && isDateOverlap(checkIn,checkOut,orders.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDateOverlap(LocalDate checkIn, LocalDate checkOut, OrderEntity order) {
        boolean res;
        if(order.getCheckInDate().isBefore(checkOut) && order.getCheckOutDate().isAfter(checkIn)){
            //then overlap
            res = true;
        } else {
            res = false;
        }
        return res;
    }
    private int findRoomNum(List<RoomEntity> rooms, int roomId) {
        int thisRoomNum = -1;
        for (RoomEntity room:rooms) {
            if (room.getId() == roomId){
                thisRoomNum = room.getRoomNum();
            }
        }
        return thisRoomNum;
    }
}
