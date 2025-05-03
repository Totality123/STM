package proyecto_lenguajes.stm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto_lenguajes.stm.Models.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
     @Query(value = "CALL comentarisoXsubtarea(:id_subtarea)", nativeQuery = true)
    List<Comment> listByid(@Param("id_subtarea") int id_subtarea);

}
