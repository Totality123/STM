package proyecto_lenguajes.stm.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import proyecto_lenguajes.stm.Models.User;
import proyecto_lenguajes.stm.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de usuarios")
    public String list(Model model) {
        model.addAttribute("usuarios", userService.list());
        return "index";
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