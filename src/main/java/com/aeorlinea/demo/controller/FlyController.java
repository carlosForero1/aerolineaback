package com.aeorlinea.demo.controller;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.service.CityService;
import com.aeorlinea.demo.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Fly")
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
}
