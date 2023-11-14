package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Brewery;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
	 List<Brewery> findByCity(String city);
	 List<Brewery> findByName(String name);
	 List<Brewery> findByType(String type);
	}
