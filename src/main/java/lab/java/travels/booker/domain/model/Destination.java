package lab.java.travels.booker.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_destination")
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String name;
	
	private String description;
	
	@OneToMany(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TravelStop> travelStops;
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<TravelStop> getTravelStops() {
		return travelStops;
	}
	public void setTravelStops(List<TravelStop> travelStops) {
		this.travelStops = travelStops;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
