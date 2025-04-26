package proyecto_lenguajes.stm.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proyecto_lenguajes.stm.Models.Comment;
import proyecto_lenguajes.stm.repository.CommentRepository;

@Service
@AllArgsConstructor
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> get() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getById(int id) {
        return commentRepository.findById(id);
    }

    public void delete(int id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> list() {
        return commentRepository.findAll();
    }

    public Comment update(int id, Comment comment) {
        Optional<Comment> existingcomment = commentRepository.findById(id);
        if (existingcomment.isPresent()) {
            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("Comentario no encontrado con ID: " + id);
        }
    }
}
