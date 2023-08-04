package com.example.hotelbookingweb.services.admin;

import com.example.hotelbookingweb.entities.DeletedOrderEntity;
import com.example.hotelbookingweb.entities.OrderEntity;
import com.example.hotelbookingweb.model.AdminGuestDTO;
import com.example.hotelbookingweb.repositories.AdminIssueRepository;
import com.example.hotelbookingweb.repositories.DeletedOrderRepository;
import com.example.hotelbookingweb.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.hotelbookingweb.mappers.GuestJoinOrderRoomMapper.guestJoinOrderRoomToAdminGuestDTO;
import static com.example.hotelbookingweb.mappers.OrderEntityToDeletedOrderEntityMapper.toDeletedOrderEntity;

@Service
@RequiredArgsConstructor
public class AdminIssueServiceImpl implements AdminIssueService {

    private final AdminIssueRepository adminIssueRepository;
    private final OrderRepository orderRepository;
    private final DeletedOrderRepository deletedOrderRepository;

    @Override
    public List<AdminGuestDTO> getAllGuestOrders() {
        List<AdminGuestDTO> allGuestOrders;
        allGuestOrders = guestJoinOrderRoomToAdminGuestDTO(adminIssueRepository.getGuestJoinOrderRooms());
        return allGuestOrders;
    }

    @Override
    @Transactional
    public void deleteOrderByOrderId(int orderId) {
        // move to deleted_order_table and delete
        DeletedOrderEntity orderToDelete = toDeletedOrderEntity(orderRepository.select(orderId));
        deletedOrderRepository.insert(orderToDelete);
        orderRepository.delete(orderId);
    }

    @Override
    public void updatePaymentToPaid(int id) {
        OrderEntity entity = orderRepository.select(id);
        entity.setPayment("Paid");
        orderRepository.update(entity);
    }
}
