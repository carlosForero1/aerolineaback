package com.aeorlinea.demo.controller;

import com.aeorlinea.demo.entity.Fee;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.service.FeeService;
import com.aeorlinea.demo.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Fee")
public class FeeController {

    @Autowired
    private FeeService service;
    public void FeeController(FeeService service) {
        this.service = service;
    }

    @GetMapping("/validation")
    public List<Fee> getAllFee(@RequestParam boolean personalizado) {
    try {
        return service.getAllFee().stream()
                .filter(fee -> fee.isEsPersonalizado() == personalizado)
                .collect(Collectors.toList());
    }catch (Exception e){
        List<Fee> lis = new ArrayList<>();
        return lis;
    }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(@PathVariable int id) {
        Optional<Fee> fee = service.getFeeById(id);
        return fee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fee createFee(@RequestBody Fee fee) {
        return service.saveFee(fee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable int id) {
        if (service.getFeeById(id).isPresent()) {
            service.deleteFee(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/available")
    public String getAvailableFlights(@RequestParam Integer id, @RequestParam int type){
        List<Fee> fees = service.getAllFee();
        String mensaje = "Tarifa Invlida";

        for(Fee fee: fees ) {
           if (fee.getId().equals(id)){
               if (fee.getType() == type){
                   mensaje = "La tarifa es valida: "+ fee;
               }
           }
        }
        return mensaje;
    }

}
