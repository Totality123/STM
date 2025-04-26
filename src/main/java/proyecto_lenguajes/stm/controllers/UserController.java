package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Usuarios", userService.listar());
        return "index";
    }
    
}