package com.aeorlinea.demo.service;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.repository.CityRepository;
import com.aeorlinea.demo.repository.FlyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlyService {

    private final FlyRepository repository;

    public FlyService(FlyRepository flyRepository) {
        this.repository = flyRepository;
    }

    public List<Fly> getAllFly() {
        return repository.findAll();
    }

    public Fly saveFly(Fly city) {
        return repository.save(city);
    }


    public Optional<Fly> getFlyById(int id) {
        return repository.findById(id);
    }


    public void deleteFly(int id) {
        repository.deleteById(id);
    }

    public String getAvailableFlights(int cityId, LocalDate startDate, String destiny) {
        List<Fly> allFlights = repository.findAll(); // Obtiene todos los vuelos

        // Filtra los vuelos según la ciudad y fecha de salida
       // List<Fly> filteredFlights = allFlights.stream().filter(fly -> fly.getCity().getId().equals(cityId) && fly.getStartDate().after(startDate))
              //  .collect(Collectors.toList());
        System.out.println("allFlights = " + allFlights);

        String mensaje = "";

        for (Fly fly: allFlights ) {
            if (fly.getCity().getId() == cityId){
                if (fly.getStartDate().equals(startDate)){
                    if (fly.getCity().getDestiny().equals(destiny)){
                        mensaje = "encontrado, "+fly;
                    }
                }
            }else {
                mensaje = "No disponible";
            }
        }

        return mensaje;
    }


}
