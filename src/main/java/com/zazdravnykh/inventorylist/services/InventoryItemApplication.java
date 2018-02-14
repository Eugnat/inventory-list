package com.zazdravnykh.inventorylist.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/inventory")
public class InventoryItemApplication extends ResourceConfig {

    @Autowired
    public InventoryItemApplication(ObjectMapper objectMapper) {

        packages("com.zazdravnykh.inventorylist.services");
        register(new ObjectMapperContextResolver(objectMapper));
    }

}
