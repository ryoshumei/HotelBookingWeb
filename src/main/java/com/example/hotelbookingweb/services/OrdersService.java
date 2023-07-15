package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.OrderEntity;

import java.util.List;

public interface OrdersService {
    List<OrderEntity> findAllOrders();
}
