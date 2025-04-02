package com.aeorlinea.demo.ControllerView;

import com.aeorlinea.demo.entity.Fee;
import com.aeorlinea.demo.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/fee")
public class ControllerFee {

    @Autowired
    private FeeService service;

    public void FeeController(FeeService service) {
        this.service = service;
    }

    @GetMapping("/validation")
    public String getAllFee(@RequestParam boolean personalizado, Model model) {
        List<Fee> fees = service.getAllFee().stream()
                .filter(fee -> fee.isEsPersonalizado() == personalizado)
                .collect(Collectors.toList());
        model.addAttribute("fees", fees);
        return "feeList"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/{id}")
    public String getFeeById(@PathVariable int id, Model model) {
        Optional<Fee> fee = service.getFeeById(id);
        fee.ifPresent(f -> model.addAttribute("fee", f));
        return "feeDetails"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/create")
    public String showCreateFeeForm(Model model){
        model.addAttribute("fee", new Fee());
        return "feeForm";
    }

    @PostMapping("/create")
    public String createFee(@ModelAttribute Fee fee) {
        service.saveFee(fee);
        return "redirect:/fee/validation?personalizado=false";
    }

    @GetMapping("/delete/{id}")
    public String deleteFee(@PathVariable int id) {
        service.deleteFee(id);
        return "redirect:/fee/validation?personalizado=false";
    }

    @GetMapping("/available")
    public String getAvailableFlights(@RequestParam Integer id, @RequestParam int type, Model model) {
        List<Fee> fees = service.getAllFee();
        String mensaje = "Tarifa Invalida";
        Fee validFee = null;

        for (Fee fee : fees) {
            if (fee.getId().equals(id) && fee.getType() == type) {
                mensaje = "La tarifa es valida: " + fee;
                validFee = fee;
                break;
            }
        }
        model.addAttribute("message", mensaje);
        model.addAttribute("validFee", validFee);
        return "feeAvailable"; // Nombre de la plantilla Thymeleaf
    }
}