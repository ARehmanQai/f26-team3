package f2_Team3.Event.Crew.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import f2_Team3.Event.Crew.dto.EventServiceDTO;
import f2_Team3.Event.Crew.entity.EventService;
import f2_Team3.Event.Crew.entity.Provider;
import f2_Team3.Event.Crew.repository.BookedServicesRepository;
import f2_Team3.Event.Crew.repository.EventServiceRepository;
import f2_Team3.Event.Crew.repository.ProviderRepository;
import f2_Team3.Event.Crew.repository.ReviewRepository;

@Service
public class EventServiceService {

    private final EventServiceRepository eventServiceRepository;
    private final ProviderRepository providerRepository;
    private final BookedServicesRepository bookedServicesRepository;
    private final ReviewRepository reviewRepository;

    public EventServiceService(
            EventServiceRepository eventServiceRepository,
            ProviderRepository providerRepository,
            BookedServicesRepository bookedServicesRepository,
            ReviewRepository reviewRepository) {

        this.eventServiceRepository = eventServiceRepository;
        this.providerRepository = providerRepository;
        this.bookedServicesRepository = bookedServicesRepository;
        this.reviewRepository = reviewRepository;
    }

    @Transactional(readOnly = true)
    public List<EventServiceDTO> getAllServices(String status) {
        return eventServiceRepository.findAll().stream()
                .filter(service -> status == null
                        || status.isBlank()
                        || (service.getStatus() != null
                        && service.getStatus().equalsIgnoreCase(status)))
                .map(this::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public EventServiceDTO getServiceById(Long id) {
        return toDTO(findService(id));
    }

    @Transactional
    public EventServiceDTO createService(EventServiceDTO dto) {
        Provider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() ->
                        new NotFoundException(
                                "Provider not found: " + dto.getProviderId()));

        EventService service = new EventService(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getCategory(),
                dto.getStatus(),
                dto.getDuration());

        service.setProvider(provider);

        return toDTO(eventServiceRepository.save(service));
    }

    @Transactional
    public EventServiceDTO updateService(Long id, EventServiceDTO dto) {
        EventService service = findService(id);

        Provider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() ->
                        new NotFoundException(
                                "Provider not found: " + dto.getProviderId()));

        service.setName(dto.getName());
        service.setDescription(dto.getDescription());
        service.setPrice(dto.getPrice());
        service.setCategory(dto.getCategory());
        service.setStatus(dto.getStatus());
        service.setDuration(dto.getDuration());
        service.setProvider(provider);

        return toDTO(eventServiceRepository.save(service));
    }

    @Transactional
    public void deleteService(Long id) {
        EventService service = findService(id);

        // Keep historical bookings and reviews intact.
        if (bookedServicesRepository.existsByEventService_Id(id)
                || reviewRepository.existsByEventService_Id(id)) {
            throw new IllegalStateException(
                    "This service has bookings or reviews and cannot be deleted. "
                    + "Change its status to INACTIVE instead.");
        }

        eventServiceRepository.delete(service);
    }

    private EventService findService(Long id) {
        return eventServiceRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Event service not found: " + id));
    }

    private EventServiceDTO toDTO(EventService service) {
        EventServiceDTO dto = new EventServiceDTO();

        dto.setId(service.getId());
        dto.setName(service.getName());
        dto.setDescription(service.getDescription());
        dto.setPrice(service.getPrice());
        dto.setCategory(service.getCategory());
        dto.setStatus(service.getStatus());
        dto.setDuration(service.getDuration());

        if (service.getProvider() != null) {
            dto.setProviderId(service.getProvider().getId());
        }

        return dto;
    }
}