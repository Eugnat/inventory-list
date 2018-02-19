package com.zazdravnykh.inventorylist.controllers;

import com.zazdravnykh.inventorylist.services.JerseyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    JerseyClientService client;

    @GetMapping("/addUser")
    public String addUser() {

        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUserForm() {

        return "resultPage";
    }

    @GetMapping("/showAllUsers")
    public String showUsers() {


        return "userManagement";
    }
}
