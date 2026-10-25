package f2_Team3.Event.Crew.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class BookedServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String status;

    private String notes;

    @NotBlank
    private String location;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "event_service_id", nullable = false)
    private EventService eventService;

    @ManyToOne
    @JoinColumn(name = "time_slot_id", nullable = false)
    private TimeSlot timeSlot;

    public BookedServices(){

    }
    public BookedServices(String status, String notes, String location, Customer customer, EventService eventService, TimeSlot timeSlot){
        this.status = status;
        this.notes = notes;
        this.location = location;
        this.customer = customer;
        this.eventService = eventService;
        this.timeSlot = timeSlot;
    }

    public Long getId(){
        return id;
    }

    public String getStatus(){
        return status;
    }
    public String getNotes(){
        return notes;
    }
    public String getLocation(){
        return location;
    }
    public Customer getCustomer(){
        return customer;
    }
    public EventService getEventService(){
        return eventService; 
    }

    public void setStatus(String status){
        this.status = status;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setEventService(EventService eventService){
        this.eventService = eventService;
    }
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    
}
