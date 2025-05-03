package proyecto_lenguajes.stm.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import proyecto_lenguajes.stm.Models.Project_User;
import proyecto_lenguajes.stm.service.Project_UserService;

@Tag(name = "relacion Ptoyecto/Usuario", description = "API para gestionar relacion Ptoyecto/Usuario")
@RestController
@RequestMapping("/project_users")
public class Project_UserController {

    private final Project_UserService project_UserService;

    public Project_UserController(Project_UserService project_UserService) {
        this.project_UserService = project_UserService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las relaciones de un proyecto, con sus usuarios", description = "Devuelve una lista de Proyectos con usuario")
    public List<Project_User> list() {
        return project_UserService.list();
    }

    @GetMapping("/listByid/{id}")
    @Operation(summary = "Obtener todas las relaciones de un proyecto, con sus usuarios por id_proyecto", description = "Devuelve una lista de Proyectos con usuario ")
    public List<Project_User> listByid(@PathVariable int id) {
        return project_UserService.puntosXproyecto(id);
    }
    
    @PostMapping
    @Operation(summary = "Crear una nueva relación Proyecto/usuario", description = "Agrega una relación Proyecto/usuario a la base de datos")
    public Project_User add(@RequestBody Project_User p_u) {
        return project_UserService.add(p_u);
    }

    @Operation(summary = "Eliminar una relación Proyecto/usuario", description = "Elimina una relación Proyecto/usuario de la base de datos")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        project_UserService.delete(id);
    }
}
