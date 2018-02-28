package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.dao.InventoryUserRepository;
import com.zazdravnykh.inventorylist.entities.InventoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/users")
public class InventoryUserService {

    @Autowired
    private InventoryUserRepository userDAO;

    @GET
    @Produces("application/json")
    public List<InventoryUser> showAllUsers() {

        List<InventoryUser> userList = userDAO.findAll();

        if (userList != null)
            return userList;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);

    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public InventoryUser getUserById(@PathParam("id") int id) {

        InventoryUser user = userDAO.findOne(id);

        if (user != null)
            return user;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("/names/{name}")
    public InventoryUser getUserByName(@PathParam("name") String name) {

        InventoryUser user = userDAO.findByUsername(name);

        if (user != null)
            return user;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
