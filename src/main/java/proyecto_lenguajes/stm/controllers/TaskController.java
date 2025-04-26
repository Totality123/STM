package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.Models.Task;
import proyecto_lenguajes.stm.service.TaskService;

@Controller
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

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        taskService.add(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Task task) {
        taskService.update(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/percentage")
    public String getPercentage(@PathVariable int id, Model model) {
        Task task = TaskService.getById(id).orElse(null);
        if (task == null) {
            return "error"; 
        } else {
            model.addAttribute("percentage", task.getPercentage());
            return "task-percentage";
        }
    }
}