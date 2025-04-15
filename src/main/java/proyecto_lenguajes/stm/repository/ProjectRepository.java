package proyecto_lenguajes.stm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_lenguajes.stm.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
    
}
