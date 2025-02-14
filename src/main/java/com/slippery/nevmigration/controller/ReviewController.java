package com.slippery.nevmigration.controller;

import com.slippery.nevmigration.dto.ReviewDto;
import com.slippery.nevmigration.model.Reviews;
import com.slippery.nevmigration.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin("https://nev-housing.vercel.app/")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<ReviewDto> createNewReview(
                                                    @RequestParam Long userId,
                                                    @RequestParam Long listingId,
                                                    @RequestBody Reviews review){

        return ResponseEntity.ok(service.createNewReview(userId, listingId, review));
    }
    @GetMapping("/all/reviews/listing/{listingId}")
    public ResponseEntity<ReviewDto> findReviewsAllListing(@PathVariable Long listingId){
        return ResponseEntity.ok(service.findReviewsAllListing(listingId));
    }
    @DeleteMapping("/delete/review")
    public ResponseEntity<ReviewDto> deleteReview(@RequestParam Long reviewId,@RequestParam Long userId,@RequestParam Long listingId){
        return ResponseEntity.ok(service.deleteReview(reviewId, userId, listingId));
    }
}
