package lab.java.travels.booker.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.java.travels.booker.domain.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, String> {

}
