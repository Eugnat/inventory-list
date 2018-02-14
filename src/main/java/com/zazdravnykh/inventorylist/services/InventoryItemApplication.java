package com.zazdravnykh.inventorylist.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/inventory")
public class InventoryItemApplication extends ResourceConfig {

    @Autowired
    public InventoryItemApplication() {

        packages("com.zazdravnykh.inventorylist.services");
    }

}
