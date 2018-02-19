package com.zazdravnykh.inventorylist.controllers;

import com.zazdravnykh.inventorylist.entities.InventoryItem;
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
    public String showAll(Model model) {

        InventoryItem item = client.findItemById(1);

        if (item != null)
            model.addAttribute("item", item);
        else
        {
            item = new InventoryItem();
            item.setId(1);
            item.setName("my name");
            item.setQuantity(2);
            model.addAttribute("item", item);
        }

        return "overview";
    }

    @GetMapping("/showItem/{id}")
    public String showItem(@PathVariable("id") int id) {

        return "showItem";
    }
}
