package proyecto_lenguajes.stm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto_lenguajes.stm.Models.Project_User;

public interface Project_UserRepository extends JpaRepository<Project_User,Integer> {
 
     @Query(value = "CALL puntosXproyecto(:id_proyecto)", nativeQuery = true)
    List<Project_User> puntosXproyecto(@Param("id_proyecto") int id_proyecto);

}
