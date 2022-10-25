package web.Project311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Project311.model.User;
import web.Project311.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("userList", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.save(user);

        return "redirect:/users";
    }

    @PatchMapping("/update")
    public String update(@RequestParam("userId") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "newUser";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        userService.delete(id);

        return "redirect:/users";
    }
}
