package com.perfumesStore.Merfumes.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.perfumesStore.Merfumes.Entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
	Optional<Order> findById(Long id);
}