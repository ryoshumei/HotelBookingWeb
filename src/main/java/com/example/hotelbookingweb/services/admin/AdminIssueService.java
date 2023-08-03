package com.example.hotelbookingweb.services.admin;

import com.example.hotelbookingweb.model.AdminGuestDTO;

import java.util.List;

public interface AdminIssueService {
    List<AdminGuestDTO> getAllGuestOrders();

    void deleteOrderByOrderId(int orderId);

    void updatePaymentToPaid(int id);
}
