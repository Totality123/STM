package proyecto_lenguajes.stm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_lenguajes.stm.Model.Project_User;

public interface Project_UserRepository extends JpaRepository<Project_User,Integer> {
    
}
