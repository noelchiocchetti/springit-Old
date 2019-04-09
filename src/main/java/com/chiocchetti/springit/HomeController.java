package com.chiocchetti.springit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping("/")
    public String home() {
        // Test
        return "Hello, Springit";
    }
}
