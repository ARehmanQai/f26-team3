package f2_Team3.Event.Crew.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    private String serviceArea;

    @NotBlank
    private String serviceType;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String providerType;

    public Provider() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }
}