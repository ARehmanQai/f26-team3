package f2_Team3.Event.Crew.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;


@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull 
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank 
    private String comments;

    private String replyText;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "event_service_id", nullable = false)
    private EventService eventService;

    public Review(){

    }

    public Review(Integer rating, String comments, Customer customer, EventService eventService) {
        this.rating = rating;
        this.comments = comments;
        this.customer = customer;
        this.eventService = eventService;
    }

    public Long getId() {
        return id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public String getReplyText() {
        return replyText;
    }

    public Customer getCustomer() {
        return customer;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
    
}
