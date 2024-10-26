package com.perfumesStore.Merfumes.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.perfumesStore.Merfumes.Entities.OrderItem;

//import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//    List<OrderItem> findByUserId(Long userId);
}