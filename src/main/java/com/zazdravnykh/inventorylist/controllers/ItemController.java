package com.zazdravnykh.inventorylist.controllers;

import com.zazdravnykh.inventorylist.entities.InventoryItem;
import com.zazdravnykh.inventorylist.services.JerseyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.core.Response;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    JerseyClientService client;

    @GetMapping("/addItem")
    public String showAddItemPage(Model model) {

        InventoryItem item = new InventoryItem();
        model.addAttribute("item", item);

        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("item") InventoryItem item, Model model) {

        Response response = client.saveItem(item);

        if (response.getStatus() == 201)
            model.addAttribute("message", "Item added successfully with status: " + response.getStatus());
        else
            model.addAttribute("message", "Error. Response status: " + response.getStatus());

        return "resultPage";
    }

    @GetMapping("/overview")
    public String showAllItems(Model model) {

        List<InventoryItem> list = client.findAllItems();

        model.addAttribute("itemList", list);
        //model.addAttribute("helperItem", item);

        return "overview";
    }

    @GetMapping("/showItem/{id}")
    public String showItem(@PathVariable("id") int id) {

        return "showItem";
    }

    @PostMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") int id, Model model) {

        Response response = client.deleteItem(id);

        if (response.getStatus() == Response.Status.OK.getStatusCode())
            model.addAttribute("message", "Item deleted successfully with status: " + response.getStatus());
        else
            model.addAttribute("message", "Error. Response status: " + response.getStatus());

        return "resultPage";
    }
}
