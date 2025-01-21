package com.slippery.nevmigration.service;

import com.slippery.nevmigration.dto.ReviewDto;
import com.slippery.nevmigration.model.Reviews;

public interface ReviewService {
    ReviewDto createNewReview(Long userId, Long listingId,Reviews review);
    ReviewDto findReviewById(Long reviewId,Long userId,Long listingId);
    ReviewDto findReviewsAllListing(Long listingId);
    ReviewDto deleteReview(Long reviewId,Long userId,Long listingId);
}
