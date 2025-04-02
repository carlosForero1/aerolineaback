package com.aeorlinea.demo.service;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.repository.CityRepository;
import com.aeorlinea.demo.repository.FlyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Fly> getAvailableFlights(int cityId, LocalDate startDate, int destiny) {
        List<Fly> allFlights = repository.findAll();
        List<Fly> result = new ArrayList<>();

        for (Fly fly : allFlights) {
            if (fly.getCity().getId() == cityId &&
                    fly.getStartDate().equals(startDate) &&
                    fly.getCity().getDestiny() == (destiny)) {
                result.add(fly);
            }
        }

        return result;
    }
}

