package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.dao.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserById(@RequestParam("id") long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("users", user);
        return "user";
    }

    @GetMapping ("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@RequestParam("id") long id, @RequestParam("name") String name, Model model) {
        User user = userService.readUser(id);
        user.setName(name);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/{id}/edit")
    public String editUser(@RequestParam("id") long id, @RequestParam("name") String name, @ModelAttribute("user") User user) {
        user.setId(id);
        user.setName(name);
        userService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
