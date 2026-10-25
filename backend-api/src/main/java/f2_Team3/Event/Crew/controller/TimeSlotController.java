package f2_Team3.Event.Crew.controller;

import f2_Team3.Event.Crew.entity.TimeSlot;
import f2_Team3.Event.Crew.service.TimeSlotService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timeslots")
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TimeSlot createTimeSlot(@Valid @RequestBody TimeSlot timeSlot) {
        return timeSlotService.createTimeSlot(timeSlot);
    }
}