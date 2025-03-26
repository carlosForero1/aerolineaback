package com.aeorlinea.demo.controller;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/City")
public class CityController {
    @Autowired
    private  CityService cityService;
    public void CityController(CityService service) {
        this.cityService = service;
    }

    @GetMapping
    public List<City> getAllCity() {
        return cityService.getAllCity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable int id) {
        Optional<City> city = cityService.getCityById(id);
        return city.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        if (cityService.getCityById(id).isPresent()) {
            cityService.deleteCity(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
