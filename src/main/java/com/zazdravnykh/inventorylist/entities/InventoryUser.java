package com.zazdravnykh.inventorylist.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inventoryusers")
public class InventoryUser {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name = "role")
    private String role;

    public InventoryUser() {}

    public InventoryUser(String userName, String userPassword) {
        this.username = userName;
        this.password = userPassword;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryUser that = (InventoryUser) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
