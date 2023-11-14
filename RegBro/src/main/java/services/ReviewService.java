package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Review;
import repositories.ReviewRepository;

@Service
public class ReviewService {
 @Autowired
 private ReviewRepository reviewRepository;

 public List<Review> getReviewsByBreweryId(Long breweryId) {
     return reviewRepository.findByBreweryId(breweryId);
 }

 public void saveReview(Review review) {
     reviewRepository.save(review);
 }
}

