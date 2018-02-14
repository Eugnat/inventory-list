package com.zazdravnykh.inventorylist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String showIndexPage(Model model) {

        String line = "My sample string";

        model.addAttribute("sampleText", line);

        return "index";
    }

    @GetMapping("/addItem")
    public String showAddItemPage() {

        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem() {

        return "resultPage";
    }

    @GetMapping("/overview")
    public String showAll() {

        return "overview";
    }

    @GetMapping("/showItem/{id}")
    public String showItem(@PathVariable("id") int id) {

        return "showItem";
    }

    @GetMapping("/resultPage")
    public String showResultPage() {

        return "resultPage";
    }
}
