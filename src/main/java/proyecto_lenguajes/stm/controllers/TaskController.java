package proyecto_lenguajes.stm.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.Models.Task;
import proyecto_lenguajes.stm.service.TaskService;

@RestController
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

    @GetMapping("/listByid/{id}")
    @Operation(summary = "Listar tareas por Proyecto", description = "Devuelve una lista de tareas basado en un proyecto")
    public List<Task> listByid(@PathVariable int id) {
        return taskService.listByid(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Task task) {
        taskService.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Task task) {
        taskService.update(id, task);
        return ResponseEntity.ok().build();
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
