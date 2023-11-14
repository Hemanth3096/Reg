package controllers;

import java.security.Principal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.Brewery;
import Entity.Review;
import Entity.User;
import services.BreweryService;
import services.ReviewService;
import services.UserService;

//BreweryController.java
@Controller
public class BreweryController {
 @Autowired
 private BreweryService breweryService;

 @Autowired
 private ReviewService reviewService;

 @GetMapping("/search")
 public String search() {
     return "search";
 }

 @PostMapping("/search")
 public String search(@RequestParam String searchType, @RequestParam String query, Model model) {
     List<Brewery> breweries = breweryService.searchBreweries(searchType, query);
     model.addAttribute("breweries", breweries);
     return "search";
 }

 @GetMapping("/brewery/{id}")
 public String breweryDetails(@PathVariable Long id, Model model) {
     Brewery brewery = breweryService.getBreweryById(id);
     List<Review> reviews = reviewService.getReviewsByBreweryId(id);
     model.addAttribute("brewery", brewery);
     model.addAttribute("reviews", reviews);
     return "brewery";
 }

 @PostMapping("/brewery/{id}/review")
 public String addReview(@PathVariable Long id, @ModelAttribute Review review, Principal principal) {
     String username = principal.getName();
     UserService userService = null;
	User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

     review.setUser(user);
     Brewery brewery = breweryService.getBreweryById(id);
     review.setBrewery(brewery);

     reviewService.saveReview(review);
     return "redirect:/brewery/" + id;
 }
}
