package proyecto_lenguajes.stm.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.Models.Subtask;
import proyecto_lenguajes.stm.service.SubtaskService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/subtasks")
public class SubtaskController {

    private final SubtaskService subtaskService;

    public SubtaskController(SubtaskService subtaskService) {
        this.sudtaskService = sudtaskService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("subtask", subtaskService.list());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Subtask subtask) {
        subtaskService.add(subtask);
        return "redirect:/subtasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        subtaskService.delete(id);
        return "redirect:/subtasks";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Subtask subtask) {
        subtaskService.update(id, subtask);
        return "redirect:/subtasks";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        Subtask subtask = subtaskService.getById(id).orElse(null);
        if (subtask == null) {
            return "error"; 
        }
        model.addAttribute("subtask", subtask);
        return "subtask-view";
    }
}