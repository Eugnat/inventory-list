package com.zazdravnykh.inventorylist.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "role", unique = true)
    private String role;

    public Role() {}

    public Role(String roleName) {
        this.role = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return role;
    }

    public void setRoleName(String roleName) {
        this.role = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
