package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Brewery;
import repositories.BreweryRepository;

@Service
public class BreweryService {
 @Autowired
 private BreweryRepository breweryRepository;

 public List<Brewery> searchBreweries(String searchType, String query) {
     switch (searchType) {
         case "by_city":
             return breweryRepository.findByCity(query);
         case "by_name":
             return breweryRepository.findByName(query);
         case "by_type":
             return breweryRepository.findByType(query);
         default:
             throw new IllegalArgumentException("Invalid search type");
     }
 }

 public Brewery getBreweryById(Long id) {
     return breweryRepository.findById(id).orElse(null);
 }
}
