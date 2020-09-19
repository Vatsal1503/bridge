package com.bridge.resilience.bridgeresilience.controller;

import com.bridge.resilience.bridgeresilience.model.BRI;
import com.bridge.resilience.bridgeresilience.model.PDFFile;
import com.bridge.resilience.bridgeresilience.service.BRICalculationService;
import com.bridge.resilience.bridgeresilience.service.PdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class WebController {

    private static Logger logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    private BRICalculationService theBRICalculationService;

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

    @RequestMapping("/BridgeDetailsAndBRI/genratebri")
    public String saveAndGenrateBRIValue(@ModelAttribute BRI thebri) {
        double dBRI=theBRICalculationService.getsaveAndGenrateBRIValue(thebri);
        logger.info("BRI Value="+dBRI);
        return "BridgeDetailsAndBRI.html";
    }
}

