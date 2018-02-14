package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.dao.InventoryItemRepository;
import com.zazdravnykh.inventorylist.entities.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Component
@Path("/products")
public class InventoryItemService {

    @Autowired
    InventoryItemRepository itemDAO;


    @GET
    @Path("{id}")
    @Produces("text/plain")
    public String showInventoryItem(@PathParam("id") int id) {

        //InventoryItem item = itemDAO.findOne(id);

        //if (item == null)
          //  throw new WebApplicationException(Response.Status.BAD_REQUEST);

        return "testString to return";
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public InventoryItem showJsonString(@PathParam("id") int id) {

        InventoryItem item = new InventoryItem();
        item.setId(id);
        item.setName("my item");
        item.setQuantity(50);
        item.setTrackingNumber("12345");
        item.setComments("No comments");

        return item;
    }
}
