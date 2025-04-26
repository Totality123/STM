package proyecto_lenguajes.stm.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.TaskService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService TaskService;

    public TaskController(TaskService TaskService) {
        this.TaskService = TaskService;
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tareas", TaskService.listar());
        return "index";
    }
    
}