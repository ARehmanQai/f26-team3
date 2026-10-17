package f2_Team3.Event.Crew.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ReviewDTO {

    private Long id;

    @NotNull
    private Long customerId;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank
    private String comments;

    private String replyText;

    public ReviewDTO(){

    }
    public ReviewDTO(Long customerId, Integer rating, String comments){
        this.customerId = customerId;
        this.rating = rating;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
    
}
