package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import proyecto_lenguajes.stm.service.CommentService;
import proyecto_lenguajes.stm.Models.Comment;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("comments", commentService.list());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Comment comment) {
        commentService.add(comment);
        return "redirect:/comments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        commentService.delete(id);
        return "redirect:/comments";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Comment comment) {
        commentService.update(id, comment);
        return "redirect:/comments";
    }
    
}