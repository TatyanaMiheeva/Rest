package ru.miheeva.springRest.Rest.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.miheeva.springRest.Rest.entity.User;

import java.util.List;


public interface UserService {
    User findUserById(Long id);

    List<User> findAllUsers();

    void deleteUserById(Long id);

    UserDetails loadUserByUsername(String username);

    boolean saveUser(User user);

    boolean updateUser(User user);

    Long getUsernameByName(String name);

    User getUserAndRoles(User user, String[] roles);

    User getNotNullRole(User user);
}
