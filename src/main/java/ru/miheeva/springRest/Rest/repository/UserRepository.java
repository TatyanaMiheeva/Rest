package ru.miheeva.springRest.Rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.miheeva.springRest.Rest.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
