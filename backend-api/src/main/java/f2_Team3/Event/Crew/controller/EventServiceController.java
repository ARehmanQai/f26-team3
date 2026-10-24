package f2_Team3.Event.Crew.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import f2_Team3.Event.Crew.dto.EventServiceDTO;
import f2_Team3.Event.Crew.service.EventServiceService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/services")
public class EventServiceController {

    private final EventServiceService eventServiceService;

    public EventServiceController(EventServiceService eventServiceService) {
        this.eventServiceService = eventServiceService;
    }

    @GetMapping
    public List<EventServiceDTO> getAllServices(
            @RequestParam(required = false) String status) {
        return eventServiceService.getAllServices(status);
    }

    @GetMapping("/{id}")
    public EventServiceDTO getServiceById(@PathVariable Long id) {
        return eventServiceService.getServiceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventServiceDTO createService(
            @Valid @RequestBody EventServiceDTO dto) {
        return eventServiceService.createService(dto);
    }

    @PutMapping("/{id}")
    public EventServiceDTO updateService(
            @PathVariable Long id,
            @Valid @RequestBody EventServiceDTO dto) {
        return eventServiceService.updateService(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteService(@PathVariable Long id) {
        eventServiceService.deleteService(id);
    }
}