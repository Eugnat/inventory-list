package com.zazdravnykh.inventorylist.services;

import com.zazdravnykh.inventorylist.entities.InventoryItem;
import com.zazdravnykh.inventorylist.entities.InventoryUser;
import com.zazdravnykh.inventorylist.entities.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    public List<InventoryUser> findUsersByRole(String role) {

        List<InventoryUser> userList = client.target(baseUri)
                .path("inventory/roles/" + role)
                .request()
                .accept("application/json")
                .get(new GenericType<List<InventoryUser>>() {});

        return userList;
    }

    public List<InventoryUser> findAllUsers() {

        List<InventoryUser> userList = client.target(baseUri)
                                        .path("inventory/users")
                                        .request()
                                        .accept("application/json")
                                        .get(new GenericType<List<InventoryUser>>(){});

        return userList;
    }

    public Response saveUser(InventoryUser user, int id) {

         Response response = client.target(baseUri)
                            .path("inventory/users/save/" + id)
                            .request()
                            .post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));

         return response;

    }

    public Response updateUser(InventoryUser user, int id) {

        Response response = client.target(baseUri)
                                    .path("inventory/users/update/" + id)
                                    .request()
                                    .put(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));

        return response;

    }

    public Response deleteUser(int id) {

        Response response = client.target(baseUri)
                            .path("inventory/users/delete/" + id)
                            .request()
                            .delete();

        return response;
    }

    public Response saveItem(InventoryItem item) {

        Response response = client.target(baseUri)
                .path("inventory/products/save")
                .request()
                .post(Entity.entity(item, MediaType.APPLICATION_JSON_TYPE));

        return response;
    }

    public Response updateItem(InventoryItem item, int id) {

        Response response = client.target(baseUri)
                .path("inventory/products/update/" + id)
                .request()
                .put(Entity.entity(item, MediaType.APPLICATION_JSON_TYPE));

        return response;
    }

    public Response deleteItem(int id) {

        Response response = client.target(baseUri)
                .path("inventory/products/delete/" + id)
                .request()
                .delete();

        return response;
    }

    public Role findRole(int id) {

        Role role = client.target(baseUri)
                .path("inventory/roles/" + id)
                .request()
                .accept("application/json")
                .get(Role.class);


        return role;
    }
}
