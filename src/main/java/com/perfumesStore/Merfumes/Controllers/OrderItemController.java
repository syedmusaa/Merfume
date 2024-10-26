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

import com.perfumesStore.Merfumes.Entities.OrderItem;
import com.perfumesStore.Merfumes.Services.OrderItemService;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // GET: Retrieve all order items
    @GetMapping("/all")
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.findAllOrderItems();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    // GET: Retrieve a specific order item by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.findOrderItemById(id);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    // POST: Create a new order item
    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
        return new ResponseEntity<>(createdOrderItem, HttpStatus.CREATED);
    }

    // PUT: Update an existing order item by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItemDetails) {
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(id, orderItemDetails);
        return new ResponseEntity<>(updatedOrderItem, HttpStatus.OK);
    }

    // DELETE: Delete an order item by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}