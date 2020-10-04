package com.bridge.resilience.bridgeresilience.controller;

import com.bridge.resilience.bridgeresilience.model.BRI;
import com.bridge.resilience.bridgeresilience.service.BRICalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    private static Logger logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    private BRICalculationService BRICalculationService;

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

    @RequestMapping("/BridgeDetailsAndBRI/{name}")
    public String showBridgeDetailsAndBRI1(@PathVariable("name") String name, Model model) {
        model.addAttribute("BRI",new BRI());
        model.addAttribute("name", name);
        return "BridgeDetailsAndBRI.html";
    }

    @RequestMapping("/BridgeDetailsAndBRI/genratebri/{name}")
    public String saveAndGenrateBRIValue(@PathVariable("name") String name,BRI thebri,Model model) {
        //thebri.setBridge_name(name);
       // logger.info("Bridge Name "+ thebri.getBridge_name());
        double dBRI= BRICalculationService.save(thebri,name);
        logger.info("BRI Value="+dBRI);
        model.addAttribute("BRI_Value", dBRI);
        model.addAttribute("BRI",thebri);
        return "ResultOfBRI.html";
    }
}

