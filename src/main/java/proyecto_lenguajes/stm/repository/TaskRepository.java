package proyecto_lenguajes.stm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto_lenguajes.stm.Models.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    
     @Query(value = "CALL tareasXproyecto(:id_proyecto)", nativeQuery = true)
    List<Task> listByid(@Param("id_proyecto") int id_proyecto);

}
