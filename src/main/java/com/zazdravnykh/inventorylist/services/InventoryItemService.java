package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.dao.InventoryItemRepository;
import com.zazdravnykh.inventorylist.entities.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/products")
public class InventoryItemService {

    @Autowired
    InventoryItemRepository itemDAO;


    @GET
    @Path("{id}")
    @Produces("application/json")
    public InventoryItem showInventoryItem(@PathParam("id") int id) {

        InventoryItem item = itemDAO.findOne(id);

        if (item == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        return item;
    }
}
