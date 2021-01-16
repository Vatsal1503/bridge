package com.bridge.resilience.bridgeresilience.controller;

import com.bridge.resilience.bridgeresilience.extra.Trie;
import com.bridge.resilience.bridgeresilience.model.BRI;
import com.bridge.resilience.bridgeresilience.model.BRIGraph;
import com.bridge.resilience.bridgeresilience.service.BRICalculationService;
import com.bridge.resilience.bridgeresilience.service.BRIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @RequestMapping("/Dashboard")
    public String showDashboard() {
        return "Dashboard.html";
    }
    @RequestMapping("/dataofdashbord")
    public ResponseEntity<?> dataofDashboard() throws ParseException {
        List<BRI> list_of_Bridge=briService.findAllServices();
        Map<String, List<BRIGraph>> mappedData = new HashMap<>();
        for(BRI data : list_of_Bridge) {
            BRIGraph bg=new BRIGraph();
            bg.setBridge_resilience(data.getBRI());
//            String myDate = ""+data.getCreateDate();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//            Date date = sdf.parse(myDate);
//            bg.setCreateDate(date.getTime());
            bg.setCreateDate(data.getCreateDate());
            if(mappedData.containsKey(data.getBridge_name())) {
                mappedData.get(data.getBridge_name()).add(bg);
            }else {
                List<BRIGraph> tempList = new ArrayList<BRIGraph>();
                tempList.add(bg);
                mappedData.put(data.getBridge_name(), tempList);
            }

        }
        return new ResponseEntity<>(mappedData, HttpStatus.OK);
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

