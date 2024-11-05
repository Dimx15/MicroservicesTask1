package org.itm.springtask1.controller;

import org.itm.springtask1.model.User;
import org.itm.springtask1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/users/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "usersList";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model) {
        model.addAttribute("user",userService.getById(id));
        return "showUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,@PathVariable("id") int id) {
        user.setId(id);
        userService.createOrUpdateUser(user);
        return "redirect:/users/list";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }
}
