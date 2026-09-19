
# Requirements – Starter Template

**Project Name:** Event Crew \
**Team:** Abdul Rehman (Provider), Justin Highland (Customer) \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-09-15

---

## 1. Overview
**Vision.** Event Crew is a service marketplace that connects customers with event staff and service providers. The system allows customers to discover, review, and book event services while allowing providers to manage their profiles, services, and customer bookings.

**Glossary** Terms used in the project
- **Customer:** A person who uses Event Crew to find and book event services.
- **Provider:** A person or business that offers event-related services through Event Crew.
- **Event Service:** A service offered by a provider to assist with event setup, staffing, volunteering, or other event-related needs.
- **Profile:** Information about a customer or provider, including relevant personal, professional, and service-related information.
- **Booking:** A customer's request to reserve a provider's event service.
- **Work History:** Information about a provider's previous event-related experience and completed work.
- **Review:** Feedback submitted by a customer about a provider or an event service.
- **Customer Statistics:** Information available to providers about their customers and booked services.

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** — Find and book event crews.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — Promote and manage event services and manage customer bookings.

**Scope (this semester).**
- Customer and provider account profiles
- Provider profiles containing experience and event service information
- Provider work history
- Creating and managing event service listings
- Browsing available providers and event services
- Provider ratings and customer reviews
- Booking event services
- Providers viewing customer and booking statistics
- Providers viewing upcoming booked services
- Providers responding to customer reviews

**Out of scope (deferred).**
- Payment processing and online transactions
- Search and filtering based on location and time

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories
- **US‑1 — <Register and manage profile>**  
  _Story:_ As a customer, I want to register and manage my profile so that I can book event crews. 
  _Acceptance:_
  ```gherkin
  Scenario: <Register with valid credentials>
    Given <I am not registered>
    When  <I provide valid registration details>
    Then  <I should be successfully registered and logged in>
    And   <I can view my profile>
  ```

- **US‑2 — <Browse event crews>**  
  _Story:_ As a customer, I want to browse available event crews so that I can find a crew that fits my event needs. 
  _Acceptance:_
  ```gherkin
  Scenario: <Browse available event crews>
    Given <I am logged in as a customer>
    When  <I browse available event crews>
    Then  <I can view available providers and their services>
  ```


- **US‑3 — <Book an event crew>**  
  _Story:_ As a customer, I want to book an available event crew  so that I can have staff for my event. 
  _Acceptance:_
  ```gherkin
  Scenario: <Book an event crew>
    Given <I am viewing an available event crew>
    When  <I select the crew and submit a booking>
    Then  <My event crew booking should be created>
  ```


- **US‑4 — <Write a review>**  
  _Story:_ As a customer, I want to write a review for an event crew so that I can share my experience with other customers. 
  _Acceptance:_
  ```gherkin
  Scenario: <Write a review for an event crew>
    Given <I have booked and used an event crew>
    When  <I submit a review for the crew>
    Then  <My review should be posted for other customers to see>
  ```

### 2.2 Provider Stories
- **US-5 — <Create and update provider profile>**  
  _Story:_ As a provider, I want to create and update my profile so that customers can learn about my experience and qualifications.  
  _Acceptance:_
  ```gherkin
  Scenario: <Create and update provider profile>
    Given <I am logged in as a provider>
    When  <I create or update my profile>
    Then  <customers should be able to view my updated profile>
  ```

- **US-6 — <Respond to customer reviews>**  
  _Story:_ As a provider, I want to respond to reviews left by customers so that I can address customer feedback.
  _Acceptance:_
  ```gherkin
  Scenario: <Respond to a customer review>
    Given <I am logged in as a provider>
    When  <I recieve a review for my service>
    Then  <I should be able to submit a response to the review>
  ```

- **US‑7 — <Create and manage services>**  
  _Story:_ As a provider, I want to create and manage the services and skills I provide so that customers can understand what services I offer. 
  _Acceptance:_
  ```gherkin
  Scenario: <Create a service>
    Given <I am logged in as a provider>
    When  <I add a service and specify the relevant skills>
    Then  <the service should be saved and available for customers to view>
  ```

- **US‑8 — <View upcoming booked services>**  
  _Story:_ As a provider, I want to view my upcoming booked services so that I can keep track of my scheduled event commitments.  
  _Acceptance:_
  ```gherkin
  Scenario: <View upcoming booked services>
    Given <I am logged in as a provider>
    When  <I have one or more booked services>
    Then  <I should see the services that have been booked by customers>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** 95% of standard page requests should be completed within 2 seconds under typical system load.
- **Availability/Reliability:** The system should successfully process valid user actions without data loss and should handle unexpected errors without exposing or corrupting user data.
- **Security/Privacy:** The system must require authentication for protected customer and provider functions. Users must only be able to view or modify information they are authorized to access.
- **Usability:** A new user should be able to create an account, browse available services, and complete a booking without external assistance.

---

## 4. Assumptions, Constraints, and Policies
- The system assumes users have a stable internet connection and access to a modern web browser.
- Modern browsers (latest Chrome/Firefox/Edge/Safari) and stable connectivity.
- Course timeline and campus infrastructure constraints apply.
- Customers can submit reviews only for services they have booked and used.
- Providers can respond only to reviews associated with their own services.

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues. 
- **M2 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M3 Design** — architecture, schema, API outline. 
- **M4 Backend API** — key endpoints + tests. 
- **M5 Increment** — ≥2 use cases end‑to‑end. 
- **M6 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.