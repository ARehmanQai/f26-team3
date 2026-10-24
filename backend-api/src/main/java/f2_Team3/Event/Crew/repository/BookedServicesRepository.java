package f2_Team3.Event.Crew.repository;

import f2_Team3.Event.Crew.entity.BookedServices;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookedServicesRepository extends JpaRepository<BookedServices, Long> {
    boolean existsByEventService_Id(Long eventServiceId);

    java.util.List<BookedServices> findByEventService_Provider_Id(Long providerId);

    boolean existsByCustomer_IdAndEventService_IdAndStatusIgnoreCase(Long customerId, Long eventServiceId, String status);
}
