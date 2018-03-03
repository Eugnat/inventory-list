package com.zazdravnykh.inventorylist.controllers;

import com.zazdravnykh.inventorylist.services.JerseyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @Autowired
    JerseyClientService client;

    @GetMapping("/addItem")
    public String showAddItemPage() {

        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem() {

        return "resultPage";
    }

    @GetMapping("/overview")
    public String showAllItems(Model model) {


        return "overview";
    }

    @GetMapping("/showItem/{id}")
    public String showItem(@PathVariable("id") int id) {

        return "showItem";
    }
}
