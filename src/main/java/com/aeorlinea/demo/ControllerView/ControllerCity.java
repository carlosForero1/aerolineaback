package com.aeorlinea.demo.ControllerView;

import com.aeorlinea.demo.entity.City;
import com.aeorlinea.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/city")
public class ControllerCity {
    @Autowired
    private CityService cityService;

    public void CityController(CityService service) {
        this.cityService = service;
    }

    @GetMapping
    public String getAllCity(Model model) {
        List<City> cities = cityService.getAllCity();
        model.addAttribute("cities", cities);
        return "cityList";
    }

    @GetMapping("/{id}")
    public String getCityById(@PathVariable int id, Model model) {
        Optional<City> city = cityService.getCityById(id);
        city.ifPresent(c -> model.addAttribute("city", c));
        return "cityDetails"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/create")
    public String showCreateCityForm(Model model){
        model.addAttribute("city", new City());
        return "cityForm";
    }

    @PostMapping("/create")
    public String createCity(@ModelAttribute City city) {
        cityService.saveCity(city);
        return "redirect:/city"; // Redirige a la lista de ciudades
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
        return "redirect:/city"; // Redirige a la lista de ciudades
    }
}