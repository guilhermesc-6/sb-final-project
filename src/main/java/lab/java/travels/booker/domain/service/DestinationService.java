package lab.java.travels.booker.domain.service;

import lab.java.travels.booker.domain.model.Destination;

public interface DestinationService {
	Destination findById(String id);
	
	Destination create(Destination destinationToCreate);
}
