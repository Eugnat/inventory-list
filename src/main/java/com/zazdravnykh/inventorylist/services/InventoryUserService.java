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
    @Path("/roles/{role}")
    public List<InventoryUser> showUserByRole(@PathParam("role") String role) {

        List<InventoryUser> userList = userDAO.findByRole(role);

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



    @POST
    @Path("/save")
    @Consumes("application/json")
    public Response saveUser(InventoryUser user) {

        InventoryUser savedUser = userDAO.save(user);

        if (savedUser != null)
            return Response.status(Response.Status.CREATED).build();
        else
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @PUT
    @Path("update/{id}")
    @Consumes("application/json")
    public Response updateUser(InventoryUser user, @PathParam("id") int id) {

        InventoryUser existingUser = userDAO.findOne(id);

        existingUser.setUsername(user.getUsername());
        existingUser.setEnabled(user.isEnabled());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());

        InventoryUser updatedUser = userDAO.save(existingUser);

        if (updatedUser != null)
            return Response.status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteUser(@PathParam("id") int id) {

        userDAO.delete(id);

        InventoryUser user = userDAO.findOne(id);

        if (user == null)
            return Response.status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
}
