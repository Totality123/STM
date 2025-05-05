package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto_lenguajes.stm.Models.Task;
import proyecto_lenguajes.stm.service.TaskService;

@Controller
public class ReportViewController {

    private final TaskService taskService;

    public ReportViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/report/{id}")
    public String mostrarReporte(@PathVariable int id, Model model) {
        Task task = taskService.getById(id).orElse(null);
        if (task == null) {
            return "error"; // O usa un redirect o mensaje personalizado
        }
        model.addAttribute("task", task);
        return "report";
    }
}

