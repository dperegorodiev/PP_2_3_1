package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserId(@PathVariable("id") long id, Model model) {
        User user = userDAO.readUser(id);
        model.addAttribute("users", user);
        return "user";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userDAO.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        User user = userDAO.readUser(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userDAO.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/delete")
    public String deletUser(@PathVariable("id") long id) {
        userDAO.deleteUser(id);
        return "redirect:/users";
    }
}
