package com.gabrielnz.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
    private Long id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(){

    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
