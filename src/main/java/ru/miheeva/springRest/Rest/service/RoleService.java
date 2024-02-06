package ru.miheeva.springRest.Rest.service;

import ru.miheeva.springRest.Rest.entity.Role;

import java.util.Set;


public interface RoleService {
    Set<Role> getAllRoles();

    Set<Role> getRoleByName(String[] roleName);
}
