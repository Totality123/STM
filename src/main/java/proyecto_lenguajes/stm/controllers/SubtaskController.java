package proyecto_lenguajes.stm.controllers;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.Models.Subtask;
import proyecto_lenguajes.stm.service.SubtaskService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/subtasks")
@Tag(name = "Subtareas", description = "API para gestionar Subtareas")
public class SubtaskController {

    private final SubtaskService subtaskService;

    public SubtaskController(SubtaskService subtaskService) {
        this.subtaskService = subtaskService;
    }

    @GetMapping
    @Operation(summary = "Listar subtareas", description = "Devuelve una lista de todas las subtareas")
    public List<Subtask> list(Model model) {
        return subtaskService.list();
    }

    @GetMapping("/listByid/{id}")
    @Operation(summary = "Listar subtareas por tarea", description = "Devuelve una lista de todas las subtareas de una tarea")
    public List<Subtask> listByid(@PathVariable int id) {
        return subtaskService.listByid(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Agregar subtarea", description = "Agrega una nueva subtarea")
    public String add(@ModelAttribute Subtask subtask) {
        subtaskService.add(subtask);
        return "redirect:/subtasks";
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar subtarea", description = "Elimina una subtarea por su ID")
    public String delete(@PathVariable int id) {
        subtaskService.delete(id);
        return "redirect:/subtasks";
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar subtarea", description = "Actualiza una subtarea existente por su ID")
    public String update(@PathVariable int id, @ModelAttribute Subtask subtask) {
        subtaskService.update(id, subtask);
        return "redirect:/subtasks";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener subtarea por ID", description = "Devuelve los datos de una subtarea por su ID")
    public String getById(@PathVariable int id, Model model) {
        Subtask subtask = subtaskService.getById(id).orElse(null);
        if (subtask == null) {
            return "error"; 
        }
        model.addAttribute("subtask", subtask);
        return "subtask-view";
    }
}
