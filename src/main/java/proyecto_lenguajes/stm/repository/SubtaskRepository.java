package proyecto_lenguajes.stm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto_lenguajes.stm.Models.Subtask;

public interface SubtaskRepository extends JpaRepository<Subtask,Integer>{

     @Query(value = "CALL subtareasXtarea(:id_tarea)", nativeQuery = true)
    List<Subtask> listByid(@Param("id_tarea") int id_tarea);
    
} 