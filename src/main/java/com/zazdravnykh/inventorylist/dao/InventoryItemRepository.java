package com.zazdravnykh.inventorylist.dao;

import com.zazdravnykh.inventorylist.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem,Integer>{


}
