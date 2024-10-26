package com.perfumesStore.Merfumes.Services;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumesStore.Merfumes.Entities.OrderItem;
import com.perfumesStore.Merfumes.Repositories.OrderItemRepository;


@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem findOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = findOrderItemById(id); // Ensure the order item exists
        orderItem.setProduct(orderItemDetails.getProduct());
        orderItem.setQuantity(orderItemDetails.getQuantity());
        orderItem.setPrice(orderItemDetails.getPrice());
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}