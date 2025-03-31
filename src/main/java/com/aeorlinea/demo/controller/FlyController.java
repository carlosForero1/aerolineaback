package com.aeorlinea.demo.controller;

import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Fly")
@CrossOrigin(origins = "http://localhost:5173")
public class FlyController {
    @Autowired
    private FlyService service;
    public void FlyController(FlyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fly> getAllFly() {
        return service.getAllFly();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fly> getFlyById(@PathVariable int id) {
        Optional<Fly> fly = service.getFlyById(id);
        return fly.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fly createFly(@RequestBody Fly fly) {
        return service.saveFly(fly);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFly(@PathVariable int id) {
        if (service.getFlyById(id).isPresent()) {
            service.deleteFly(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/available")
    public List<Fly> getAvailableFlights(@RequestParam Integer id, @RequestParam String destiny,@RequestParam LocalDate StartDate){
        List<Fly> result= new ArrayList<>();
        String mensaje = "No hay Viajes disponibles";
        List<Fly> flies = service.getAllFly();

        for(Fly fly: flies ) {
            if (fly.getCity().getId() == id){
                if (fly.getStartDate().equals(StartDate)){
                    if (fly.getCity().getDestiny().equals(destiny)){
                        result.add(fly);
                    }
                }
            }
        }
            return result;
        }

    }



