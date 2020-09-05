package com.bridge.resilience.bridgeresilience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/sample")
    public String showForm() {
        return "index";
    }

    @RequestMapping("/home")
    public String showHome() {
        return "home";
    }

}

