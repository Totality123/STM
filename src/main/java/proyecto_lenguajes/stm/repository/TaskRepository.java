package proyecto_lenguajes.stm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_lenguajes.stm.Models.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    
}
