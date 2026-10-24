package f2_Team3.Event.Crew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import f2_Team3.Event.Crew.entity.Review;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByEventService_Id(Long eventServiceId);

    List<Review> findByEventService_Provider_Id(Long providerId);
}
