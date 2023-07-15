package com.example.hotelbookingweb.services;

import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderEntity> findAllOrders() {
        return orderRepository.getAll();
    }
}
