package com.slippery.nevmigration.service.impl;

import com.slippery.nevmigration.dto.ReviewDto;
import com.slippery.nevmigration.model.Listing;
import com.slippery.nevmigration.model.Reviews;
import com.slippery.nevmigration.model.User;
import com.slippery.nevmigration.repository.ListingRepository;
import com.slippery.nevmigration.repository.ReviewRepository;
import com.slippery.nevmigration.repository.UserRepository;
import com.slippery.nevmigration.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ListingRepository listingRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, ListingRepository listingRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
    }

    @Override
    public ReviewDto createNewReview(Long userId, Long listingId,Reviews review) {
        ReviewDto response =new ReviewDto();
        Optional<User> existingUser =userRepository.findById(userId);
        Optional<Listing> existingListing =listingRepository.findById(listingId);
        if(existingListing.isEmpty()){
            response.setMessage("listing was not found");
            response.setStatusCode(404);
            return response;
        }
        if(existingUser.isEmpty()){
            response.setMessage("User was not found");
            response.setStatusCode(404);
            return response;
        }
        if(review ==null){
            response.setMessage("review body can not be blank");
            response.setStatusCode(401);
            return response;
        }
//        save review
        Reviews reviews =new Reviews();
        reviews.setReview(review.getReview());
        reviews.setListingId(listingId);
        reviews.setUserId(userId);
        reviewRepository.save(reviews);
//        update listing
        var reviewList =existingListing.get().getReviewsList();
        reviewList.add(reviews);
        existingListing.get().setReviewsList(reviewList);
        listingRepository.save(existingListing.get());
//        update user
        var userReviews =existingUser.get().getReviewsList();
        userReviews.add(reviews);
        existingUser.get().setReviewsList(userReviews);
        userRepository.save(existingUser.get());

        response.setMessage("New review created");
        response.setStatusCode(200);
        response.setReview(reviews);

        return response;
    }

    @Override
    public ReviewDto findReviewById(Long reviewId, Long userId, Long listingId) {
        return null;
    }

    @Override
    public ReviewDto findReviewsAllListing(Long listingId) {
        ReviewDto response =new ReviewDto();
        Optional<Listing> existingListing =listingRepository.findById(listingId);
        if(existingListing.isEmpty()){
            response.setMessage("Listing was not found! ");
            response.setStatusCode(404);
            return response;
        }
        var reviews =existingListing.get().getReviewsList();
        response.setReviews(reviews);
        response.setMessage("All reviews for listing with id "+listingId);
        response.setStatusCode(200);

        return response;
    }

    @Override
    public ReviewDto deleteReview(Long reviewId, Long userId, Long listingId) {
        ReviewDto response =new ReviewDto();
        Optional<User> existingUser =userRepository.findById(userId);
        Optional<Listing> existingListing =listingRepository.findById(listingId);
        Optional<Reviews> existingReview =reviewRepository.findById(reviewId);

        if(existingReview.isEmpty()){
            response.setMessage("review was not found");
            response.setStatusCode(404);
            return response;
        }
        if(existingListing.isEmpty()){
            response.setMessage("listing was not found");
            response.setStatusCode(404);
            return response;
        }
        if(existingUser.isEmpty()){
            response.setMessage("User was not found");
            response.setStatusCode(404);
            return response;
        }
        if(!existingReview.get().getListingId().equals(listingId) || !existingReview.get().getUserId().equals(userId)){
            response.setMessage("review does not belong to the user");
            response.setStatusCode(401);
            return response;
        }
        var reviews =existingListing.get().getReviewsList();

        reviews.remove(existingReview.get());
        existingListing.get().setReviewsList(reviews);
        listingRepository.save(existingListing.get());

        var userReviews =existingUser.get().getReviewsList();
        userReviews.remove(existingReview.get());
        existingUser.get().setReviewsList(userReviews);
        userRepository.save(existingUser.get());
        return response;
    }
}
