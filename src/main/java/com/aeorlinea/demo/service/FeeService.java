package com.aeorlinea.demo.service;

import com.aeorlinea.demo.entity.Fee;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.repository.FeeRepository;
import com.aeorlinea.demo.repository.FlyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FeeService {

    private  FeeRepository repository;

    public FeeService(FeeRepository feeRepository) {
        this.repository = feeRepository;
    }

    public List<Fee> getAllFee() {
        return repository.findAll();
    }

    public Fee saveFee(Fee fee) {
        return repository.save(fee);
    }


    public Optional<Fee> getFeeById(int id) {
        return repository.findById(id);
    }


    public void deleteFee(int id) {
        repository.deleteById(id);
    }
}
