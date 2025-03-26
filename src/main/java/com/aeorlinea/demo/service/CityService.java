package com.aeorlinea.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.repository.CityRepository;

@Service
public class CityService {
     private final CityRepository cityRepository;

     public CityService(CityRepository cityRepository) {
          this.cityRepository = cityRepository;
     }

     public List<City> getAllCity() {
          return cityRepository.findAll();
     }

     public City saveCity(City city) {
          return cityRepository.save(city);
     }


     public Optional<City> getCityById(int id) {
          return cityRepository.findById(id);
     }


     public void deleteCity(int id) {
          cityRepository.deleteById(id);
     }
}
