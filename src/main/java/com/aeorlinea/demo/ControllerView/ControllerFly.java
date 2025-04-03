package com.aeorlinea.demo.ControllerView;


import com.aeorlinea.demo.entity.Fee;
import com.aeorlinea.demo.entity.Fly;
import com.aeorlinea.demo.entity.feePrueba;
import com.aeorlinea.demo.service.FeeService;
import com.aeorlinea.demo.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fly")
public class ControllerFly {
    @Autowired
    private FlyService service;

    @Autowired
    private FeeService serviceFee;

    public void FlyController(FlyService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllFly(Model model) {
        List<Fly> flies = service.getAllFly();
        model.addAttribute("flies", flies);
        return "flyList"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/{id}")
    public String getFlyById(@PathVariable int id, Model model) {
        Optional<Fly> fly = service.getFlyById(id);
        fly.ifPresent(f -> model.addAttribute("fly", f));
        return "flyDetails"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/create")
    public String showCreateFlyForm(Model model) {
        model.addAttribute("fly", new Fly());
        return "flyForm";
    }

    @PostMapping("/create")
    public String createFly(@ModelAttribute Fly fly) {
        service.saveFly(fly);
        return "redirect:/fly";
    }

    @GetMapping("/delete/{id}")
    public String deleteFly(@PathVariable int id) {
        service.deleteFly(id);
        return "redirect:/fly";
    }

    @GetMapping("/available")
    public String getAvailableFlights(@RequestParam Integer id, @RequestParam Integer destiny, @RequestParam LocalDate StartDate, Model model) {
        List<Fly> result = service.getAvailableFlights(id, StartDate,destiny);
        model.addAttribute("availableFlights", result);
        return "flyAvailable";
    }
    @GetMapping("/search")
    public String showFlySearchForm() {
        return "flySearch";
    }


    @GetMapping("/{id}/tarifas")
    public String showFeeSelectionForm(@PathVariable("id") int flyId, Model model) {
        Optional<Fly> vueloOptional = service.getFlyById(flyId);
        if (vueloOptional.isPresent()) {
            Fly vuelo = vueloOptional.get();
            // Crear tarifas preestablecidas
            List<feePrueba> tarifas = Arrays.asList(
                    new feePrueba(1, "Económica", "Tarifa básica"),
                    new feePrueba(2, "Ejecutiva", "Tarifa con beneficios"),
                    new feePrueba(3, "Primera Clase", "Tarifa premium")
            );
            model.addAttribute("vuelo", vuelo);
            model.addAttribute("tarifas", tarifas);
            return "feeSelection";
        } else {
            model.addAttribute("error", "Vuelo no encontrado.");
            return "error";
        }
    }

    @PostMapping("/{id}/tarifas")
    public String processFeeSelection(@PathVariable("id") int flyId, @RequestParam("tarifaId") int tarifaId, Model model) {
        model.addAttribute("message", "Tarifa seleccionada y guardada.");
        return "guardado"; // Crea una vista "guardado.html"
    }


    @GetMapping("/results")
    public String showFlyResults(
            @RequestParam(value = "cityId", required = false) Integer cityId,
            @RequestParam(value = "destino", required = false) Integer destino,
            @RequestParam(value = "fecha", required = false) LocalDate fecha,
            Model model) {

        if (cityId != null && destino != null && fecha != null) {
            List<Fly> vuelos = service.getAvailableFlights(cityId, fecha, destino);
            model.addAttribute("vuelos", vuelos);
        } else {
            model.addAttribute("vuelos", null);
        }

        return "flyResults";
    }

}