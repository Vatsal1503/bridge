package com.bridge.resilience.bridgeresilience.controller;

import com.bridge.resilience.bridgeresilience.extra.Trie;
import com.bridge.resilience.bridgeresilience.model.BRI;
import com.bridge.resilience.bridgeresilience.service.BRICalculationService;
import com.bridge.resilience.bridgeresilience.service.BRIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    private static Logger logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    @Qualifier(value = "briCalculationService")
    private BRICalculationService briCalculationService;

    @Autowired
    @Qualifier(value = "briService")
    private BRIService briService;

    @Autowired
    @Qualifier(value = "trie")
    private Trie trieService;

    @RequestMapping("/")
    public String showForm() {
        return "redirect:/home.html";
    }

    @RequestMapping("/home.html")
    public String showHome(Model model) {
        model.addAttribute("BRI",new BRI());
        return "home.html";
    }

    @RequestMapping("/about.html")
    public String showAbout() {
        return "about.html";
    }

//    @RequestMapping("/contact.html")
//    public String showContactUs() {
//        return "contact.html";
//    }

    @RequestMapping("/BridgeDetailsAndBRI.html")
    public String showBridgeDetailsAndBRI() {
        return "BridgeDetailsAndBRI.html";
    }

    @RequestMapping("/BridgeDetailsAndBRI/{name}")
    public String showBridgeDetailsAndBRI1(@PathVariable("name") String name, Model model) {
        //trieService.insert(name);
        model.addAttribute("BRI",new BRI());
        model.addAttribute("name", name);
        return "BridgeDetailsAndBRI.html";
    }

    @RequestMapping("/BridgeDetailsAndBRI/genratebri/{name}")
    public String saveAndGenrateBRIValue(@PathVariable("name") String name,BRI thebri,Model model) {
        //thebri.setBridge_name(name);
       // logger.info("Bridge Name "+ thebri.getBridge_name());
        double dBRI= briCalculationService.save(thebri,name);
        //logger.info("BRI Value="+dBRI);
        model.addAttribute("BRI_Value", dBRI);
        model.addAttribute("BRI",thebri);
        return "ResultOfBRI.html";
    }
    @GetMapping("/reports")
    public String sreach_opration(BRI thebri, Model model){
        //logger.info("Bridge Name :"+thebri.getBridge_name());
        List<BRI> selected_Bridge=briService.findByIdServices(thebri.getBridge_name());
        if(selected_Bridge==null) {
            throw new IllegalArgumentException("Invalid Bridge Name :" + thebri.getBridge_name());
        }
        model.addAttribute("list_of_Bridge",selected_Bridge);
        return "Reports.html";
    }
    @RequestMapping("/listofbridge")
    public String listofBridge(Model model) {
        List<BRI> list_of_Bridge=briService.findAllServices();
        model.addAttribute("list_of_Bridge",list_of_Bridge);
        return "Reports.html";
    }
}

