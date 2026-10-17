package f2_Team3.Event.Crew.controller;

import f2_Team3.Event.Crew.dto.ReviewDTO;
import f2_Team3.Event.Crew.service.ReviewService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; 

@RestController
@RequestMapping("/api/services/{serviceId}/reviews")
public class ReviewController{
    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> submitReview(
            @PathVariable Long serviceId,
            @Valid @RequestBody ReviewDTO reviewDTO) {

        ReviewDTO createdReview = reviewService.submitReview(serviceId, reviewDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

}
