package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.entity.TimeSlot;
import f2_Team3.Event.Crew.repository.TimeSlotRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    public TimeSlot createTimeSlot(TimeSlot timeSlot) {

        validateTimes(timeSlot);
        return timeSlotRepository.save(timeSlot);
    }

    public TimeSlot updateTimeSlot(Long id, TimeSlot updatedTimeSlot) {
        TimeSlot existingTimeSlot = timeSlotRepository.findById(id).orElseThrow(() -> new NotFoundException("Time slot not found"));

        validateTimes(updatedTimeSlot);

        existingTimeSlot.setStartTime(updatedTimeSlot.getStartTime());
        existingTimeSlot.setEndTime(updatedTimeSlot.getEndTime());

        return timeSlotRepository.save(existingTimeSlot);
    }



    
}
