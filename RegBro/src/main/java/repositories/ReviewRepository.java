package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
 List<Review> findByBreweryId(Long breweryId);
}
