package com.zazdravnykh.inventorylist.controllers;

import com.zazdravnykh.inventorylist.entities.InventoryUser;
import com.zazdravnykh.inventorylist.entities.Role;
import com.zazdravnykh.inventorylist.entities.UserHelper;
import com.zazdravnykh.inventorylist.services.JerseyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.core.Response;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    public String addUserForm(@ModelAttribute("newUser") UserHelper user, Model model) {

        InventoryUser newUser = new InventoryUser(user.getName(),user.getPassword());
        newUser.setEnabled(true);

        Role role = client.findRole(user.getRole());

        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        Response response = client.saveUser(newUser);

        if (response.getStatus() == 201)
            model.addAttribute("resultLine", "User added successfully");
        else
            model.addAttribute("resultLine", "User not added due to an error");

        return "resultPage";
    }

    @GetMapping("/showAllUsers")
    public String showUsers(Model model) {

        List<InventoryUser> list = client.findAllUsers();

        model.addAttribute("userList",list);

        return "userManagement";
    }
}
