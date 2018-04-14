package com.zazdravnykh.inventorylist.dao;

import com.zazdravnykh.inventorylist.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findById (int id);
}
