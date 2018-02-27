package com.zazdravnykh.inventorylist.entities;

import java.util.Objects;

public class UserHelper {

    private String name;
    private String password;
    private String repeatPassword;
    private String role;

    public UserHelper() {}

    public UserHelper(String name, String password, String repeatPassword, String role) {
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHelper that = (UserHelper) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
