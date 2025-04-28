package proyecto_lenguajes.stm.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import proyecto_lenguajes.stm.Models.Project;
import proyecto_lenguajes.stm.service.ProjectService;

@Tag(name = "Projectos", description = "API para gestionar Proyectos") // Grupo en Swagger
@RestController
@RequestMapping("/")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los Proyectos", description = "Devuelve una lista de Proyectos")
    public List<Project> list() {
        return projectService.list();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un proyecto por ID", description = "Busca un proyecto en la base de datos según su ID")
    public Project get(@PathVariable int id) {
        return projectService.get(id);
       
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo proyecto", description = "Agrega un proyecto a la base de datos")
    public Project add(@RequestBody Project project) {
        return projectService.add(project);
    }

    @Operation(summary = "Modificar un Proyecto", description = "Modifica un Proyecto existene en la base de datos")
    @PutMapping("/{id}")
    public Project update(@PathVariable int id, @RequestBody Project project) {
        return projectService.update(id, project);
    }

    @Operation(summary = "Eliminar un proyecto", description = "Elimina un proyecto de la base de datos")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        projectService.delete(id);
    }

    //pendientes el obtener Puntuacion y el obtener porcentuaje, yas que tengo que preparar eso en la DATABASE
    
    

}