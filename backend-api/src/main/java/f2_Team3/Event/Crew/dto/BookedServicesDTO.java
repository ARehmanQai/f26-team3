package f2_Team3.Event.Crew.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class BookedServicesDTO {

    private Long id;

    @NotNull
    private Long customerId;

    @NotNull
    private Long eventServiceId;

    @NotBlank
    private String status;

    @NotBlank
    private String notes;

    @NotBlank
    private String location;

    public BookedServicesDTO() {
    }
    public BookedServicesDTO(Long customerId, Long eventServiceId, String status, String notes, String location) {
        this.customerId = customerId;
        this.eventServiceId = eventServiceId;
        this.status = status;
        this.notes = notes;
        this.location = location;
    }
     public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getEventServiceId() {
        return eventServiceId;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setEventServiceId(Long eventServiceId) {
        this.eventServiceId = eventServiceId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
