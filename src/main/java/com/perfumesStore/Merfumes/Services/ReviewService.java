package com.perfumesStore.Merfumes.Services;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumesStore.Merfumes.Entities.OrderItem;
import com.perfumesStore.Merfumes.Entities.Review;
import com.perfumesStore.Merfumes.Repositories.OrderItemRepository;
import com.perfumesStore.Merfumes.Repositories.ReviewRepository;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    public Review findReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        Review review = findReviewById(id); // Ensure the review exists
        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());
        review.setUser(reviewDetails.getUser());
        review.setPerfume(reviewDetails.getPerfume());
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}