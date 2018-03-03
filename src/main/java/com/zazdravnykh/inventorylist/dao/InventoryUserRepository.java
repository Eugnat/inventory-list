package com.zazdravnykh.inventorylist.dao;

import com.zazdravnykh.inventorylist.entities.InventoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryUserRepository extends JpaRepository<InventoryUser,Integer> {

    InventoryUser findByUsername(String name);
    List<InventoryUser> findByRole(String role);
}
