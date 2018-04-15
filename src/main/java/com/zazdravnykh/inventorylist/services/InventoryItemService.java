package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.dao.InventoryItemRepository;
import com.zazdravnykh.inventorylist.entities.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/products")
public class InventoryItemService {

    @Autowired
    InventoryItemRepository itemDAO;

    @GET
    @Produces("application/json")
    public List<InventoryItem> showAllItems() {

        List<InventoryItem> itemList = itemDAO.findAll();

        if (itemList != null)
            return itemList;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);

    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public InventoryItem showItemById(@PathParam("id") int id) {

        InventoryItem item = itemDAO.findOne(id);

        if (item != null)
            return item;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    @Path("/save")
    @Consumes("application/json")
    public Response saveItem(InventoryItem item) {

        InventoryItem savedItem = itemDAO.save(item);

        if (savedItem != null)
            return Response.status(Response.Status.CREATED).build();
        else
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteItem(@PathParam("id") int id) {

        itemDAO.delete(id);

        InventoryItem item = itemDAO.findOne(id);

        if (item == null)
            return Response.status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateItem(InventoryItem item, @PathParam("id") int id) {

        InventoryItem existingItem = itemDAO.findOne(id);

        existingItem.setQuantity(item.getQuantity());
        existingItem.setName(item.getName());
        existingItem.setTrackingNumber(item.getTrackingNumber());
        existingItem.setComments(item.getComments());

        InventoryItem updatedItem = itemDAO.save(existingItem);

        if (updatedItem != null)
            return Response.status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }




}
