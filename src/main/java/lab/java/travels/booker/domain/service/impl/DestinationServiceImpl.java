package lab.java.travels.booker.domain.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lab.java.travels.booker.domain.model.Destination;
import lab.java.travels.booker.domain.repository.DestinationRepository;
import lab.java.travels.booker.domain.service.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {

	private final DestinationRepository destinationRepository;
	
	public DestinationServiceImpl(DestinationRepository destinationRepository) {
		this.destinationRepository = destinationRepository;
	}
	
	
	@Override
	public Destination findById(String id) {
		return destinationRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Destination create(Destination destinationToCreate) {
		if(destinationToCreate.getId() != null && destinationRepository.existsById(destinationToCreate.getId())) {
			throw new IllegalArgumentException("This user already exists!");
		}
		return destinationRepository.save(destinationToCreate);
	}

}
