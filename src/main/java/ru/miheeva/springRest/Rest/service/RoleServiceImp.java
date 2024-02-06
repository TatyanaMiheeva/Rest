package ru.miheeva.springRest.Rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miheeva.springRest.Rest.entity.Role;
import ru.miheeva.springRest.Rest.repository.RoleRepository;


import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService{
    private final RoleRepository roleRepository;
    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Set<Role> getRoleByName(String[] roleName) {
        Set<Role> roleSet = new HashSet<>();
        for (String role: roleName)
            roleSet.add(roleRepository.findRoleByName(role));
        return roleSet;
    }
}
