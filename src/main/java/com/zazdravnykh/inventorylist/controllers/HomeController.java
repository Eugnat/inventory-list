package com.zazdravnykh.inventorylist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String showIndexPage(Model model) {

        String line = "My sample string";

        model.addAttribute("sampleText", line);

        return "index";
    }



    @GetMapping("/legal")
    public String showLegal() {


        return "legal";
    }

    @PostMapping("/login")
    public String login(){
        return "index";
    }


}
