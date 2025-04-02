package com.aeorlinea.demo.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfiController {

    @GetMapping("/")
    public String inicio(Model model) {
        return "redirect:/city";
    }
}