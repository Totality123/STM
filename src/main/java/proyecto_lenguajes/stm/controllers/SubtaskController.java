package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.SubtaskService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/subtasks")
public class SubtaskController {

    private final SubtaskService sudtaskService;

    public SubtaskController(SubtaskService sudtaskService) {
        this.sudtaskService = sudtaskService;
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Subtareas", sudtaskService.listar());
        return "index";
    }
    
}