package com.brainycode.mustache_demo.controllers;

import com.brainycode.mustache_demo.model.Product;
import com.brainycode.mustache_demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        // Variables
        model.addAttribute("title", "Figgy's Mustache Example");
        User user = new User("Alice", true);
        model.addAttribute("user", user);

        // Section: list of products
        List<Product> products = List.of(
                new Product("Chocolate Cake", "$12.00"),
                new Product("Croissant", "$3.50"),
                new Product("Blueberry Muffin", "$4.25")
        );

        model.addAttribute("products", products);
        model.addAttribute("premiumMessage", user.isPremium());

        return "home";
    }
}
