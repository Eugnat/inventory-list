package com.zazdravnykh.inventorylist.controllers;

import com.zazdravnykh.inventorylist.entities.UserHelper;
import com.zazdravnykh.inventorylist.services.JerseyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    JerseyClientService client;

    @GetMapping("/addUser")
    public String addUser(Model model, Principal principal) {

        UserHelper user = new UserHelper();

        model.addAttribute("newUser", user);

        String principalName = principal.getName();

        if (principalName.equals("jack"))
            return "addUser";
        else
            return "addUserSimple";
    }

    @PostMapping("/addUser")
    public String addUserForm(@ModelAttribute("newUser") UserHelper newUser) {


        return "resultPage";
    }

    @GetMapping("/showAllUsers")
    public String showUsers() {


        return "userManagement";
    }
}
