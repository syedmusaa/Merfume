package com.perfumesStore.Merfumes.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumesStore.Merfumes.Entities.Order;
import com.perfumesStore.Merfumes.Repositories.OrderRepository;


@Service
public class OrderService {

	    @Autowired
	    private OrderRepository orderRepository;

	    public List<Order> findAllOrders() {
	        return orderRepository.findAll();
	    }
	    
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    public Order findOrderById(Long id) {
	        return orderRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Order not found"));
	    }

	    public Order createOrder(Order order) {
	        return orderRepository.save(order);
	    }

	    public Order updateOrder(Long id, Order orderDetails) {
	        Order order = findOrderById(id); // Ensure the order exists
	        order.setTotalAmount(orderDetails.getTotalAmount());
	        order.setStatus(orderDetails.getStatus());
	        return orderRepository.save(order);
	    }

	    public void deleteOrder(Long id) {
	        orderRepository.deleteById(id);
	    }
	}