package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.dao.RoleRepository;
import com.zazdravnykh.inventorylist.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Component
@Path("/roles")
public class RoleService {

    @Autowired
    RoleRepository roleDAO;

    @GET
    @Path("{name}")
    @Produces("application/json")
    public Role findRoleByName(@PathParam("name") String roleName) {

        Role role = roleDAO.findByRole(roleName);

        return role;
    }

}
