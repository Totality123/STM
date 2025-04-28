package proyecto_lenguajes.stm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import proyecto_lenguajes.stm.Models.Project_User;
import proyecto_lenguajes.stm.service.Project_UserService;

@Controller
@RequestMapping("/project_users")
public class Project_UserController {

    private final Project_UserService project_UserService;

    public Project_UserController(Project_UserService project_UserService) {
        this.project_UserService = project_UserService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las relaciones de un proyecto, con sus usuarios", description = "Devuelve una lista de Proyectos con usuario")
    public List<Project_User> list(Model model) {
        return project_UserService.list();
    }
    
    @PostMapping
    @Operation(summary = "Crear una nuevo relacion Proyecto/usuario con usuario", description = "Agrega una relacion Proyecto/usuario con usuario a la base de datos")
    public Project_User add(@RequestBody Project_User p_u) {
        return project_UserService.add(p_u);
    }

    @Operation(summary = "Eliminar una relacion Proyecto/usuario", description = "Elimina una relacion Proyecto/usuario de la base de datos")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        project_UserService.delete(id);
    }
}