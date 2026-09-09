package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("quote_of_the_day", "Crafting delightful treats and delivering fresh joy to your doorstep every morning!");
        return "index"; // resolves to index.mustache
    }
}
