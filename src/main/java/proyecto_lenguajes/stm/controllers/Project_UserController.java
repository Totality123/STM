package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.Project_UserService;


@Controller
@RequestMapping("/project_users")
public class Project_UserController {

    private final Project_UserService project_UserService;

    public Project_UserController(Project_UserService project_UserService) {
        this.project_UserService = project_UserService;
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Relacion usuario/proyecto", project_UserService.listar());
        return "index";
    }
    
}