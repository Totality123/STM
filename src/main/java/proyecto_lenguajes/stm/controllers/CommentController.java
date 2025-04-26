package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.CommentService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Comentarios", commentService.listar());
        return "index";
    }
    
}