package ru.miheeva.springRest.Rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.miheeva.springRest.Rest.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
