package com.bridge.resilience.bridgeresilience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String showForm() {
        return "redirect:/home.html";
    }

    @RequestMapping("/home.html")
    public String showHome() {
        return "home.html";
    }

    @RequestMapping("/about.html")
    public String showAbout() {
        return "about.html";
    }

    @RequestMapping("/contact.html")
    public String showContactUs() {
        return "contact.html";
    }

    @RequestMapping("/BridgeDetailsAndBRI.html")
    public String showBridgeDetailsAndBRI() {
        return "BridgeDetailsAndBRI.html";
    }

}

