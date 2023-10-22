package lab.java.travels.booker.domain.controller;



import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lab.java.travels.booker.domain.model.Destination;
import lab.java.travels.booker.domain.service.DestinationService;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

	@Autowired
	private DestinationService destinationService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Destination> findById(@PathVariable("id") String id){
		var destination = destinationService.findById(id);
		return ResponseEntity.ok(destination);
	}
	
	@PostMapping
	public ResponseEntity<Destination> create(@RequestBody Destination destination){
		var destinationCreated = destinationService.create(destination);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(destination.getId())
				.toUri();
		return ResponseEntity.created(location).body(destinationCreated);
	}
}
