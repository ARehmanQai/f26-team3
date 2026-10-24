package f2_Team3.Event.Crew.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class EventService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @NotNull
    @DecimalMin("0.0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotBlank
    private String category;
    @NotBlank
    private String status;

    @NotNull
    @Min(1)
    private Integer duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    @JsonIgnore
    private Provider provider;

    public EventService(){

    }
    public EventService(String name, String description, BigDecimal price, String category, String status, Integer duration) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.category = category;
    this.status = status;
    this.duration = duration;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    public String getStatus(){
        return status;
    }
    public Integer getDuration(){
        return duration;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(BigDecimal price){
    this.price = price;
    }

    public void setCategory(String category){
    this.category = category;
    }

        public void setStatus(String status){
    this.status = status;
    }

    public void setDuration(Integer duration){
    this.duration = duration;
    }

    public Provider getProvider() {
    return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
}
