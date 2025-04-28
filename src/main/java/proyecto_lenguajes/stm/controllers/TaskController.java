package proyecto_lenguajes.stm.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.Models.Task;
import proyecto_lenguajes.stm.service.TaskService;

@Controller
@RequestMapping("/tasks")
@Tag(name = "Tareas", description = "API para gestionar Tareas")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Operation(summary = "Listar tareas", description = "Devuelve una lista de todas las tareas")
    public List<Task> list(Model model) {
        return taskService.list();
    }

    @PostMapping("/add")
    @Operation(summary = "Agregar tarea", description = "Agrega una nueva tarea")
    public String add(@ModelAttribute Task task) {
        taskService.add(task);
        return "redirect:/tasks";
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar tarea", description = "Elimina una tarea por su ID")
    public String delete(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar tarea", description = "Actualiza una tarea existente por su ID")
    public String update(@PathVariable int id, @ModelAttribute Task task) {
        taskService.update(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/percentage")
    @Operation(summary = "Obtener porcentaje de tarea", description = "Devuelve el porcentaje completado de una tarea")
    public String getPercentage(@PathVariable int id, Model model) {
        Task task = taskService.getById(id).orElse(null);
        if (task == null) {
            return "error"; 
        } else {
            model.addAttribute("percentage", task.getPercentage());
            return "task-percentage";
        }
    }
}
