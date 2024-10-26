package com.perfumesStore.Merfumes.Controllers;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfumesStore.Merfumes.Entities.Order;

import com.perfumesStore.Merfumes.Services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	 @Autowired
	    private OrderService orderService;

	    // GET: Retrieve all orders
	    @GetMapping("/all")
	    public ResponseEntity<List<Order>> getAllOrders() {
	        List<Order> orders = orderService.findAllOrders();
	        return new ResponseEntity<>(orders, HttpStatus.OK);
	    }

	    // GET: Retrieve a specific order by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
	        Order order = orderService.findOrderById(id);
	        return new ResponseEntity<>(order, HttpStatus.OK);
	    }

	    // POST: Create a new order
	    @PostMapping("/create")
	    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	        Order createdOrder = orderService.createOrder(order);
	        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	    }

	    // PUT: Update an existing order by ID
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
	        Order updatedOrder = orderService.updateOrder(id, orderDetails);
	        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
	    }
	    
//	    @PutMapping("/{id}")
//	    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
//	        return orderService.getOrderById(id)
//	                .map(order -> {
//	                    order.setName(orderDetails.getName());
//	                    order.setBrand(orderDetails.getBrand());
//	                    order.setPrice(orderDetails.getPrice());
//	                    order.setDescription(orderDetails.getDescription());
//	                    return ResponseEntity.ok(orderService.saveOrder(order));
//	                })
//	                .orElse(ResponseEntity.notFound().build());
//	    }
	    
	    
	    
	    // DELETE: Delete an order by ID
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	        orderService.deleteOrder(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}