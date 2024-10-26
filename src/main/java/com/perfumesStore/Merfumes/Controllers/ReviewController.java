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

import com.perfumesStore.Merfumes.Entities.Perfume;
import com.perfumesStore.Merfumes.Entities.Review;
import com.perfumesStore.Merfumes.Services.PerfumeService;
import com.perfumesStore.Merfumes.Services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // GET: Retrieve all reviews
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // GET: Retrieve a specific review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // POST: Create a new review
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    // PUT: Update an existing review by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Review updatedReview = reviewService.updateReview(id, reviewDetails);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    // DELETE: Delete a review by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}