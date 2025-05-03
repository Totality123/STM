package proyecto_lenguajes.stm.controllers;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.CommentService;
import proyecto_lenguajes.stm.Models.Comment;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/comments")
@Tag(name = "Comentarios", description = "API para gestionar Comentarios")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @GetMapping
    @Operation(summary = "Listar comentarios", description = "Devuelve una lista de todos los comentarios")
    public List<Comment> list(Model model) {
        return commentService.list();
    }

    @GetMapping("/listByid/{id}")
    @Operation(summary = "Lista comentarios por subtareas", description = "Devuelve una lista de los comentarios por id de subtarea")
    public List<Comment> listByid(@PathVariable int id) {
        return commentService.listByid(id);
    }
    

    @PostMapping("/add")
    @Operation(summary = "Agregar comentario", description = "Agrega un nuevo comentario")
    public String add(@ModelAttribute Comment comment) {
        commentService.add(comment);
        return "redirect:/comments";
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar comentario", description = "Elimina un comentario por su ID")
    public String delete(@PathVariable int id) {
        commentService.delete(id);
        return "redirect:/comments";
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar comentario", description = "Actualiza un comentario existente por su ID")
    public String update(@PathVariable int id, @ModelAttribute Comment comment) {
        commentService.update(id, comment);
        return "redirect:/comments";
    }  
}
