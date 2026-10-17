package f2_Team3.Event.Crew.service;
import org.springframework.stereotype.Service;

import f2_Team3.Event.Crew.entity.EventService;
import f2_Team3.Event.Crew.repository.EventServiceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceService {

    private final EventServiceRepository eventServiceRepository;

    public EventServiceService(EventServiceRepository eventServiceRepository) {
        this.eventServiceRepository = eventServiceRepository;
    }

    public List<EventService> getAllServices() {
    return eventServiceRepository.findAll();
    }

    public Optional<EventService> getServiceById(Long id) {
    return eventServiceRepository.findById(id);
    }
    
}
