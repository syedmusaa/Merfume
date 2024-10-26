package com.perfumesStore.Merfumes.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.perfumesStore.Merfumes.Entities.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//    List<Review> findByUserId(Long userId);
}