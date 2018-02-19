package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.entities.InventoryItem;
import com.zazdravnykh.inventorylist.entities.InventoryUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.List;

@Service
public class JerseyClientService {

    @Value("${my.location}")
    private String baseUri;

    private Client client;

    public JerseyClientService() {

        client = ClientBuilder.newClient();
    }


    public InventoryItem findItemById(int id) {

        InventoryItem item = client.target(baseUri)
                                    .path("inventory/products/1")
                                    .request()
                                    .accept("application/json")
                                    .get(InventoryItem.class);
        return item;
    }

    public List<InventoryItem> findAllItems() {

        return null;
    }

    public InventoryUser findUserById(int id) {

        return null;
    }

    public List<InventoryUser> findAllUsers() {

        return null;
    }

    public void saveUser(InventoryUser user) {

    }

    public void saveItem(InventoryItem item) {


    }
}
