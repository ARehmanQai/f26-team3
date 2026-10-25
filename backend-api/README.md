## UML Diagram

![Class Diagram](../docs/UMLEventCrew.png)

## API Overview

**Version:** 1.0  
**Last Updated:** October 23, 2026

**Base URL:**

- local: `http://localhost:8080/api`

## Live Deployment

https://f26-team3.onrender.com

## Customer Profile Management

| Method | Path | Purpose | Response Code | User Story / Use Case | Implemented By |
| ------ | ---- | ------- | ------------- | --------------------- | -------------- |
| `POST` | `/api/customers` | Create a customer profile | `201 Created` | Create Customer Profile | Justin |
| `GET` | `/api/customers/{id}` | Retrieve a customer profile by ID | `200 OK` | View Customer Profile | Justin |
| `PUT` | `/api/customers/{id}` | Update a customer profile | `200 OK` | Modify Customer Profile | Justin |
| `DELETE` | `/api/customers/{id}` | Delete a customer profile by ID | `204 No Content` | Delete Customer Profile | Justin |

### Example Customer Requests

#### Create a Customer

```http
POST /api/customers
Content-Type: application/json
```

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "ExamplePassword123!",
  "phoneNumber": "3365550101"
}
```

#### Update a Customer

```http
PUT /api/customers/1
Content-Type: application/json
```

```json
{
  "name": "John Doe",
  "email": "john.doe.updated@example.com",
  "password": "UpdatedExamplePassword123!",
  "phoneNumber": "3365550199"
}
```

#### Get a Customer

```http
GET /api/customers/1
```

#### Delete a Customer

```http
DELETE /api/customers/1
```

## Service Booking Management

| Method | Path | Purpose | Response Code | User Story / Use Case | Implemented By |
| ------ | ---- | ------- | ------------- | --------------------- | -------------- |


| `POST` | `/api/customers/{customerId}/subscriptions` | Book an event service | `201 Created` | Book Event Service | Justin |
| `PUT` | `/api/customers/{customerId}/subscriptions/{bookingId}/cancel` | Cancel a booked service | `204 No Content` | Cancel Booking | Justin |

#### Book a Service


```http
POST /api/customers/1/subscriptions
Content-Type: application/json ```

```json
{
  "customerId": 1,
  "eventServiceId": 1,
  "timeSlotId": 1,
  "notes": "Please set up the decorations before the event.",
  "location": "Greensboro, NC"
}
```
#### Cancel a Booked Service

```http
PUT /api/customers/1/subscriptions/1/cancel
```


## Review Management

| Method | Path | Purpose | Response Code | User Story / Use Case | Implemented By |
| ------ | ---- | ------- | ------------- | --------------------- | -------------- |

| `POST` | `/api/services/{serviceId}/reviews` | Submit a review for an event service | `201 Created` | Review Event Service | Justin |

#### Submit a Review

```http
POST /api/services/1/reviews
Content-Type: application/json
```

```json
{
  "customerId": 1,
  "rating": 5,
  "comments": "Excellent service! Everything was organized and completed on time."
}
```

## Time Slot Management

| Method | Path | Purpose | Response Code | User Story / Use Case | Implemented By |
| ------ | ---- | ------- | ------------- | --------------------- | -------------- |
| `POST` | `/api/timeslots` | Create a time slot with a start and end time | `201 Created` | Manage Service Time Slots | Justin |

### Example Time Slot Request

#### Create a Time Slot

```http
POST /api/timeslots
Content-Type: application/json
```

```json
{
  "startTime": "2026-10-30T10:00:00",
  "endTime": "2026-10-30T14:00:00"
}
```