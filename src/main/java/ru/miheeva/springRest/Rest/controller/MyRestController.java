package ru.miheeva.springRest.Rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.miheeva.springRest.Rest.entity.Role;
import ru.miheeva.springRest.Rest.entity.User;
import ru.miheeva.springRest.Rest.service.RoleServiceImp;
import ru.miheeva.springRest.Rest.service.UserServiceImp;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyRestController {

    private final UserServiceImp userServiceImp;
    private final RoleServiceImp roleServiceImp;


    @GetMapping("/users")
    public List<User> showAllUser(){
       return userServiceImp.findAllUsers();
    }

    @GetMapping("/roles")
    public List<Role> showAllRole(){
        return new ArrayList<>(roleServiceImp.getAllRoles());
    }

    @PostMapping("/user-save")
    public User saveUser(@RequestBody User user){
        userServiceImp.saveUser(user);
        return user;
    }

    @PutMapping("/user-update")
    public User updateUser(@RequestBody User user){
        userServiceImp.updateUser(user);
        return user;
    }

    @DeleteMapping("/user-delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userServiceImp.deleteUserById(id);
    }

}
