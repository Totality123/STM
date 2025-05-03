package proyecto_lenguajes.stm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import proyecto_lenguajes.stm.Models.User;
import proyecto_lenguajes.stm.service.UserService;

@Tag(name = "Usuarios", description = "API para gestionar Usuarios") // Grupo en Swagger
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de usuarios")
    public List<User> list() {
        return userService.list() ;
    }

    @GetMapping("/listByid/{id}")
    @Operation(summary = "Obtener todos los usuarios por un proyecto", description = "Devuelve una lista de usuarios pertenecinetes a un proyecto")
    public List<User> listByid(@PathVariable int id) {
        return userService.listByid(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Busca un usuario en la base de datos según su ID")
    public Optional<User> get(@PathVariable int id) {
        return userService.get(id);
       
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario", description = "Agrega un usuario a la base de datos")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @Operation(summary = "Modificar un usuario", description = "Modifica un usuario existene en la base de datos")
    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @Operation(summary = "Eliminar un proyecto", description = "Elimina un proyecto de la base de datos")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    
}