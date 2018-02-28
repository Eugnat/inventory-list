package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.entities.InventoryItem;
import com.zazdravnykh.inventorylist.entities.InventoryUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
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
                                    .path("inventory/products/" + id)
                                    .request()
                                    .accept("application/json")
                                    .get(InventoryItem.class);
        return item;
    }

    public List<InventoryItem> findAllItems() {

        List<InventoryItem> list = client.target(baseUri)
                                          .path("inventory/products")
                                          .request()
                                          .accept("application/json")
                                          .get(new GenericType<List<InventoryItem>>() {});

        return list;
    }

    public InventoryUser findUserById(int id) {

        InventoryUser user = client.target(baseUri)
                                    .path("inventory/users/" + id)
                                    .request()
                                    .accept("application/json")
                                    .get(InventoryUser.class);

        return user;
    }

    public InventoryUser findUserByName(String name) {

        InventoryUser user = client.target(baseUri)
                .path("inventory/users/names/" + name)
                .request()
                .accept("application/json")
                .get(InventoryUser.class);

        return user;
    }

    public List<InventoryUser> findAllUsers() {

        List<InventoryUser> list = client.target(baseUri)
                                        .path("inventory/users/")
                                        .request()
                                        .accept("application/json")
                                        .get(new GenericType<List<InventoryUser>>(){});

        return list;
    }

    public void saveUser(InventoryUser user) {

    }

    public void updateUser(InventoryUser user, int id) {

    }

    public void deleteUser(int id) {


    }

    public void saveItem(InventoryItem item) {


    }

    public void updateItem(InventoryItem item, int id) {

    }

    public void deleteItem(int id) {

    }
}
