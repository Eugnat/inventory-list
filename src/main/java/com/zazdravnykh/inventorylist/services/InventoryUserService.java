package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.dao.InventoryUserRepository;
import com.zazdravnykh.inventorylist.entities.InventoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

@Component
@Path("/users")
public class InventoryUserService {

    @Autowired
    private InventoryUserRepository userDAO;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public InventoryUser showUserById(@PathParam("id") int id) {

        InventoryUser user = userDAO.findOne(id);

        if (user != null)
            return user;
        else
            throw new WebApplicationException("No user with this identifier");
    }

    @GET
    @Path("/name/{name}")
    public InventoryUser showUserByName(@PathParam("name") String name) {

        InventoryUser user = userDAO.findByUsername(name);

        if (user != null)
            return user;
        else
            throw new WebApplicationException("No user with this name");
    }
}
