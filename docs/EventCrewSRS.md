
# Requirements – Starter Template

**Project Name:** Event Crew \
**Team:** Abdul Rehman (Provider), Justin Highland (Customer) \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-09-15

---

## 1. Overview
**Vision.** Event Crew connects customers with event staff and service providers, making it easier to find and book reliable crews for events.

**Glossary** Terms used in the project
- **Customer:** A person who uses Event Crew to find and book event services.
- **Provider:** description

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** — Find and book event crews.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — 1 line goal statement.


**Scope (this semester).**
- <Profiles (Customer and Provider)>
- <Reviews/Ratings>
- <Browse and Book services>
- <Create services and list work history>

**Out of scope (deferred).**
- <Payment system>
- <Search by location and time>

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

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
- **US-20 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US-21 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.3 SysAdmin Stories
- **US‑30 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑31 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

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