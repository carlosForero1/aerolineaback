package com.aeorlinea.demo.service;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.repository.CityRepository;
import com.aeorlinea.demo.repository.FlyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
