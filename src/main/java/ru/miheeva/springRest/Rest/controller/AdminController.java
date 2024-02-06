package ru.miheeva.springRest.Rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.miheeva.springRest.Rest.entity.User;
import ru.miheeva.springRest.Rest.service.RoleServiceImp;
import ru.miheeva.springRest.Rest.service.UserServiceImp;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImp userService;
    private final RoleServiceImp roleService;
    @GetMapping
    public String showAllUser(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("allUser", users);
        return "admin";
    }

    @PostMapping("/user-save")
    public String saveUser(User user){
        userService.getNotNullRole(user);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user-save")
    public String saveUserForm(Model model){
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", new User());
        return "admin-save";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles", required = false) String[] roles){
        userService.getUserAndRoles(user, roles);
        userService.updateUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", userService.findUserById(id));
        return "admin-update";
    }
//    @GetMapping("/admin")
//    public List<User> showAllUser(Model model){
//       return userService.findAllUsers();
//    }
//
//    @PostMapping("/admin/user-save")
//    public User saveUser(User user){
//        userService.getNotNullRole(user);
//        userService.saveUser(user);
//        return user;
//    }
//
//    @GetMapping("/admin/user-save")
//    public Model saveUserForm(Model model){
//        model.addAttribute("roles", roleService.getAllRoles());
//        model.addAttribute("user", new User());
//        return model;
//    }
//
//    @DeleteMapping("/admin/user-delete/{id}")
//    @ResponseStatus(HttpStatus.SEE_OTHER) //для перенаправления на admin
//    public void deleteUser(@PathVariable("id") Long id){
//        userService.deleteUserById(id);
//    }
//
//    @PostMapping("/admin/user-update")
//    public User updateUser(@ModelAttribute("user") User user,
//                             @RequestParam(value = "nameRoles", required = false) String[] roles){
//        userService.getUserAndRoles(user, roles);
//        userService.updateUser(user);
//        return user;
//    }
//    @GetMapping("/admin/user-update/{id}")
//    public Model updateUserForm(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("roles", roleService.getAllRoles());
//        model.addAttribute("user", userService.findUserById(id));
//        return model;
//    }
}
