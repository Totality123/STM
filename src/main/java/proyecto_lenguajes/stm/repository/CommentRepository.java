package proyecto_lenguajes.stm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_lenguajes.stm.Models.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
}
