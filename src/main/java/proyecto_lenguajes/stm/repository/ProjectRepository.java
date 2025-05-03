package proyecto_lenguajes.stm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto_lenguajes.stm.Models.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

    @Query(value = "CALL projects_by_id(:idUsuario)", nativeQuery = true)
    List<Project> listByid(@Param("idUsuario") int idUsuario);

}
