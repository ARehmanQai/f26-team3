package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.dto.ReviewDTO;
import f2_Team3.Event.Crew.entity.Customer;
import f2_Team3.Event.Crew.entity.EventService;
import f2_Team3.Event.Crew.entity.Review;
import f2_Team3.Event.Crew.repository.CustomerRepository;
import f2_Team3.Event.Crew.repository.EventServiceRepository;
import f2_Team3.Event.Crew.repository.ReviewRepository;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;
    private final EventServiceRepository eventServiceRepository;

    public ReviewService(ReviewRepository reviewRepository, CustomerRepository customerRepository, EventServiceRepository eventServiceRepository) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
        this.eventServiceRepository = eventServiceRepository;
    }

    public ReviewDTO submitReview(Long serviceId, ReviewDTO reviewDTO) {
        Customer customer = customerRepository.findById(reviewDTO.getCustomerId())
            .orElseThrow(() -> new NotFoundException("Customer not found"));

        EventService eventService = eventServiceRepository.findById(serviceId)
            .orElseThrow(() -> new NotFoundException("Event service not found"));

            Review review = new Review(reviewDTO.getRating(), reviewDTO.getComments(), customer, eventService);


    Review savedReview = reviewRepository.save(review);

    ReviewDTO response = new ReviewDTO(savedReview.getCustomer().getId(), savedReview.getRating(), savedReview.getComments());


    response.setId(savedReview.getId());
    response.setReplyText(savedReview.getReplyText());

    return response;



    }

    
}
