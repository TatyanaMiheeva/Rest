package ru.miheeva.springRest.Rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.miheeva.springRest.Rest.entity.User;
import ru.miheeva.springRest.Rest.service.UserServiceImp;


import java.security.Principal;

@Controller //@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServiceImp userService;

    @GetMapping()
    public String showUser(Principal principal, Model model) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("oneUser", user);
        return "/user";

    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUsers(@ModelAttribute("user") User user, Principal principal) {
        userService.getUserForUpdateUsers(user, principal.getName());
        userService.updateUser(user);
        return "redirect:/user";
    }

    @GetMapping("/news")
    public String showNews() {
        return "/news";
    }
//    @GetMapping("/user")
//    public User showUser(Principal principal) {
//        return  (User) userService.loadUserByUsername(principal.getName());
//    }
//
//    @GetMapping("/user/user-update/{id}")
//    public Model updateUserForm(@PathVariable("id") Long id, Model model) {
//        return model.addAttribute("user", userService.findUserById(id));
//    }
//
//    @PostMapping("/user/user-update")
//    public User updateUsers(@ModelAttribute("user") User user, Principal principal) {
//        userService.getUserForUpdateUsers(user, principal.getName());
//        userService.updateUser(user);
//        return user;
//    }
//
//    @GetMapping("/news")
//    public String showNews() {
//        return "Страница для пользователей без роли";
//    }
}
